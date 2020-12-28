package com.shayanne.desafioshayanne.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.shayanne.desafioshayanne.R
import com.shayanne.desafioshayanne.adapter.MeuAdapter
import com.shayanne.desafioshayanne.databinding.ActivityMainBinding
import com.shayanne.desafioshayanne.modelo.Items
import com.shayanne.desafioshayanne.webservices.InicializadorRetrofit.initRep
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity() : AppCompatActivity(), MeuAdapter.ItemClickListener{



    private val callGit by lazy { initRep() }
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        //  pega o id do recycleview que esta no activity_main e coloca numa variavel para poder usar
        //val idDoMeuRecycleView = findViewById<RecyclerView>(R.id.recyclerview_id)

        // a linha 31 cria uma lista linear para scrolar
        //idDoMeuRecycleView.adapter = adapter
       // idDoMeuRecycleView.layoutManager = LinearLayoutManager(this)
        //idDoMeuRecycleView.setHasFixedSize(true)

        // intent usado para testar o return da segunda tela, pra retornar até a primeira pagina, vide manifest tb
        // se colocado aqui a primeira tela que vai aparecer é a Detalherepositorio, se tirar, é a MainActivity
        //passei pra fun  ItemClick
        //val intencao = Intent(this, DetalheRepositorio::class.java)
        // startActivity(intencao)

        callGit.getGit().enqueue(object : Callback<Items> {
            override fun onResponse(
                call: Call<Items>,
                response: Response<Items>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        binding.recyclerviewId.adapter =
                            MeuAdapter(it.item,this@MainActivity)
                    }
                }
            }
            override fun onFailure(call: Call<Items>, t: Throwable) {
                Log.d("Erro", t.message.toString())
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun ItemClick(position: Int) {
        //passa o Intent pra chamar o DetalheRepositorio, e o startActivity pra mostra-la na tela
        val intencao = Intent(this, DetalheRepositorio::class.java)
        startActivity(intencao)
    }

}

private fun <T> Call<T>.enqueue(callback: Callback<Items>) {

}



