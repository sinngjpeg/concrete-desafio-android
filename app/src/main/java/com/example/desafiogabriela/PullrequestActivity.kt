package com.example.desafiogabriela

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiogabriela.api.InicializadorDeRetrofit.get
import com.example.desafiogabriela.model.Itens
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PullrequestActivity: AppCompatActivity() {

    private val get by lazy { get() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pullrequest)

        setSupportActionBar(findViewById(R.id.pull_toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }}


//        get.busca().enqueue(object : Callback<Itens> {
//            override fun onResponse(
//                call: Call<Itens>, response: Response<Itens>
//            ) {
//                val recyclerView = findViewById<RecyclerView>(R.id.pullrequest)
//
//                if (response.isSuccessful) {
//                    response.body()?.let {
//                        recyclerView.adapter = NotePullrequestAdapter(it.itensPull, this@PullrequestActivity)
//                    }
//                }
//            }
//
//
//            override fun onFailure(call: Call<Itens>, t: Throwable) {
//                Log.d("erro inesperado", t.message.toString())
//                Toast.makeText(this@PullrequestActivity, "erro", Toast.LENGTH_LONG).show()
//            }
//        })
//    }


//
//        val exemplo  = generateDummyList(500)
//
//
//        var pullrequest = findViewById<RecyclerView>(R.id.pullrequest)
//
//
//        pullrequest.adapter = NotePullrequestAdapter(exemplo)
//        pullrequest.layoutManager = LinearLayoutManager(this)
//        pullrequest.setHasFixedSize(true)

//}
//
//    private fun generateDummyList(size: Int): List<ItemPullrequest> {
//        val list = ArrayList<ItemPullrequest>()
//        for (i in 0 until size) {
//            val drawable = when (i % 3) {
//                0 -> R.drawable.ic_pessoa
//                1 -> R.drawable.ic_pessoa
//                else -> R.drawable.ic_pessoa
//            }
//            val item = ItemPullrequest (drawable, "Título do Pullrequest","descriptionkjsfnvfvvyujyyvytvfvjuikhghdxfghvbjhjfctghvjkghvjknlytfevjugnlmfomlioerfnanvlifjvrjvdfivndflijvleriovodfnvdifovrt", "username","Nome Sobrenome")
//            list += item
//        }
//        return list
//    }
