package com.example.desafiogabriela.activity

import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiogabriela.model.ItemRepository
import com.example.desafiogabriela.adapter.RepositoryAdapter
import com.example.desafiogabriela.webservice.InicializadorDeRetrofit.get
import com.example.desafiogabriela.databinding.ActivityRepositoryBinding

import com.example.desafiogabriela.model.Items
import com.example.desafiogabriela.utils.Constante

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RepositoryActivity : AppCompatActivity(),
    RepositoryAdapter.OnItemClickListener {

    var page = 1
    var lastPosition = 0
    var isLoading = false
    val list = ArrayList<ItemRepository>()

    private val get by lazy { get() }
    private val adapter = RepositoryAdapter(list, this)
    private lateinit var binding: ActivityRepositoryBinding
    lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityRepositoryBinding.inflate(layoutInflater)
        setContentView(binding.root)


        layoutManager = LinearLayoutManager(this)
        binding.repositorio.layoutManager = layoutManager
        binding.repositorio.adapter = adapter

        binding.repositorio.setHasFixedSize(true)

        getPage(page)

        binding.repositorio.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val lastCompleteItem = layoutManager.findLastVisibleItemPosition()


                if (!isLoading) {
                    if (lastCompleteItem == adapter.itemCount - 1) {
                        lastPosition = adapter.itemCount
                        page += 1
                        getPage(page)
                        binding.progressBar.visibility = View.VISIBLE
                    }
                }
            }

        })
    }


    fun getPage(page: Int) {
        isLoading = true
        get.busca(page).enqueue(object : Callback<Items> {
            override fun onResponse(
                call: Call<Items>, response: Response<Items>
            ) {

                if (response.isSuccessful) {
                    response.body()?.let {
                        adapter.list.addAll(it.items)
                        adapter.notifyDataSetChanged()
                        list.addAll(it.items)
                        isLoading = false
                    }
                }
            }
            override fun onFailure(call: Call<Items>, t: Throwable) {
                Log.d("erro inesperado", t.message.toString())
                Toast.makeText(this@RepositoryActivity, "erro", Toast.LENGTH_LONG).show()
            }
        })
    }


    override fun onItemClick(position: Int) {
        val intent = Intent(this, PullrequestActivity::class.java)
        intent.putExtra(Constante.owner, adapter.list[position].owner.username)
        intent.putExtra(Constante.repositorio, adapter.list[position].nameRepository)
        intent.putExtra(Constante.foto, adapter.list[position].owner.image)
        startActivity(intent)
    }

}


