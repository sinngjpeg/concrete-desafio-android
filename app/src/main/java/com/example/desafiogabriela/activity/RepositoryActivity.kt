package com.example.desafiogabriela.activity

import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiogabriela.Constante
import com.example.desafiogabriela.model.ItemMain
import com.example.desafiogabriela.R
import com.example.desafiogabriela.adapter.RepositoryAdapter
import com.example.desafiogabriela.webservice.InicializadorDeRetrofit.get
import com.example.desafiogabriela.databinding.ActivityRepositoryBinding

import com.example.desafiogabriela.model.Itens

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRepositoryBinding.inflate(layoutInflater)
        setContentView(binding.root)



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
    }


    override fun onItemClick(position: Int) {
        val intencao = Intent(this, PullrequestActivity::class.java)
        intencao.putExtra(Constante.owner, adapter.list[position].owner.login)
        intencao.putExtra(Constante.repositorio,adapter.list[position].name)
        intencao.putExtra(Constante.foto, adapter.list[position].owner.avatar_url)
        startActivity(intencao)
    }
}


