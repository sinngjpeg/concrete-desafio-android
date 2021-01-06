package com.example.desafiogabriela.activity

import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiogabriela.model.ItemMain
import com.example.desafiogabriela.R
import com.example.desafiogabriela.adapter.RepositoryAdapter
import com.example.desafiogabriela.webservice.InicializadorDeRetrofit.get
import com.example.desafiogabriela.databinding.ActivityRepositoryBinding

import com.example.desafiogabriela.model.Itens
import com.example.desafiogabriela.utils.Constante

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RepositoryActivity : AppCompatActivity(),
    RepositoryAdapter.OnItemClickListener {

    private val get by lazy { get() }
    private val lista = ArrayList<ItemMain>()
    private val adapter = RepositoryAdapter(lista, this)

    private lateinit var binding: ActivityRepositoryBinding
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var recycleViewId: RecyclerView
    private lateinit var viewManager: RecyclerView.LayoutManager

    //scroll

    val numberList: MutableList<String> = ArrayList()
    var page = 1
    var isLoading = false
    var limit = 10
    lateinit var adapterScroll: NumberAdapter
    lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRepositoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //scroll
        layoutManager = LinearLayoutManager(this)
        binding.repositorio.layoutManager= layoutManager



        viewManager = LinearLayoutManager(this)
        viewAdapter =
            RepositoryAdapter(
                ArrayList(),
                this
            )


        recycleViewId = findViewById<RecyclerView>(R.id.repositorio).apply {

            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }


        get.busca().enqueue(object : Callback<Itens> {
            override fun onResponse(
                call: Call<Itens>, response: Response<Itens>
            ) {

                if (response.isSuccessful) {
                    response.body()?.let {
                        binding.repositorio.adapter =
                            RepositoryAdapter(
                                it.items,
                                this@RepositoryActivity
                            )
                        lista.addAll(it.items)
                    }
                }
            }


            override fun onFailure(call: Call<Itens>, t: Throwable) {
                Log.d("erro inesperado", t.message.toString())
                Toast.makeText(this@RepositoryActivity, "erro", Toast.LENGTH_LONG).show()
            }
        })

        getPage()

        binding.repositorio.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {

                if (dy> 0){
                    val visibleItemCount = layoutManager.childCount
                    val pastVisibleItem = layoutManager.findFirstCompletelyVisibleItemPosition()
                    val total = adapter.itemCount

                    if(!isLoading){
                        if ((visibleItemCount + pastVisibleItem) >= total){
                            getPage()
                        }
                    }
                }

                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }


    fun getPage(){

        isLoading = true
        binding.progressBar.visibility = View.VISIBLE
        val start = ((page)*limit) + 1
        val end = (page)*limit

        for (i in start..end){
            numberList.add("Item" + i.toString())
        }


            if(::adapterScroll.isInitialized){
                adapterScroll.notifyDataSetChanged()
            }else{
                adapterScroll = NumberAdapter(this)
                binding.repositorio.adapter = adapterScroll
            }
        isLoading = false
        binding.progressBar.visibility = View.GONE


    }






    override fun onItemClick(position: Int) {
        val intencao = Intent(this, PullrequestActivity::class.java)
        intencao.putExtra(Constante.owner, adapter.list[position].owner.login)
        intencao.putExtra(Constante.repositorio,adapter.list[position].name)
        intencao.putExtra(Constante.foto, adapter.list[position].owner.avatar_url)
        startActivity(intencao)
    }

    class NumberAdapter (val activity: RepositoryActivity): RecyclerView.Adapter<NumberAdapter.NumberViewHolder>(){


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
            return NumberViewHolder(LayoutInflater.from(activity).inflate(R.layout.rv_number,parent , false))
        }

        override fun getItemCount(): Int {
            return activity.numberList.size
        }

        override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
            holder.tvNumber.text = activity.numberList[position]
        }

        class NumberViewHolder (v : View) : RecyclerView.ViewHolder(v){
            val tvNumber = v.findViewById<TextView>(R.id.tv_number)
        }

    }
}


