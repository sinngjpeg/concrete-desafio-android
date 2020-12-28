package com.example.desafiogabriela

import android.app.Activity
import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiogabriela.api.InicializadorDeRetrofit.get
import com.example.desafiogabriela.databinding.ActivityMainBinding
import com.example.desafiogabriela.model.Itens

import com.example.desafiogabriela.webservice.WebClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Arrays.toString
import java.util.Objects.toString


class MainActivity : AppCompatActivity(), NoteListAdapter.OnItemClickListener {

    private val get by lazy { get() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.repositorio.layoutManager = LinearLayoutManager(this)
        binding.repositorio.setHasFixedSize(true)
        binding.repositorio.adapter


        get.busca().enqueue(object : Callback<Itens> {
            override fun onResponse(
                call: Call<Itens>, response: Response<Itens>
            ) {
                val recyclerView = findViewById<RecyclerView>(R.id.repositorio)

                if (response.isSuccessful) {
                    response.body()?.let {
                        recyclerView.adapter = NoteListAdapter(it.itens, this@MainActivity)
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

