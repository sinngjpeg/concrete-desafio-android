package com.example.desafiogabriela

import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiogabriela.api.InicializadorDeRetrofit.get
import com.example.desafiogabriela.databinding.ActivityMainBinding
import com.example.desafiogabriela.model.Itens

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity(), NoteListAdapter.OnItemClickListener {

    private val get by lazy { get() }

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var recycleViewId: RecyclerView
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewManager = LinearLayoutManager(this)
        viewAdapter = NoteListAdapter(emptyList(), this)


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
                            NoteListAdapter(it.items, this@MainActivity)
                    }
                }
            }


            override fun onFailure(call: Call<Itens>, t: Throwable) {
                Log.d("erro inesperado", t.message.toString())
                Toast.makeText(this@MainActivity, "erro", Toast.LENGTH_LONG).show()
            }
        })
    }


    override fun onItemClick(position: Int) {
        val intencao = Intent(this, PullrequestActivity::class.java)
        startActivity(intencao)
    }
}


