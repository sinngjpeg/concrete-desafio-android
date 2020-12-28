package com.shayanne.desafioshayanne.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
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

    private lateinit var idDoMeuRecycleView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewManager = LinearLayoutManager(this)
      //  viewAdapter = MeuAdapter(myDataset)

        idDoMeuRecycleView = findViewById<RecyclerView>(R.id.recyclerview_id).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
          //  adapter = viewAdapter
        }






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
                            MeuAdapter(it.items,this@MainActivity)
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





