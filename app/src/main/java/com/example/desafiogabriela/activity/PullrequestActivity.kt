package com.example.desafiogabriela.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiogabriela.Constante
import com.example.desafiogabriela.model.ItemPullrequest
import com.example.desafiogabriela.adapter.PullrequestAdapter
import com.example.desafiogabriela.R
import com.example.desafiogabriela.webservice.InicializadorDeRetrofitPull.getPull
import com.example.desafiogabriela.databinding.ActivityPullrequestBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PullrequestActivity : AppCompatActivity() {

    private val getPull by lazy { getPull() }

    var owner = ""
    var repositorio = ""

    private lateinit var bindingPull: ActivityPullrequestBinding
    private lateinit var viewAdapterPull: RecyclerView.Adapter<*>
    private lateinit var recycleViewIdPull: RecyclerView
    private lateinit var viewManagerPull: RecyclerView.LayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        owner = intent.getStringExtra(Constante.owner).toString()
        repositorio = intent.getStringExtra(Constante.repositorio).toString()

        super.onCreate(savedInstanceState)
        bindingPull = ActivityPullrequestBinding.inflate(layoutInflater)
        setContentView(bindingPull.root)

        setSupportActionBar(findViewById(R.id.pull_toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewAdapterPull =
            PullrequestAdapter(
                ArrayList(),
                this
            )
        viewManagerPull = LinearLayoutManager(this)

        recycleViewIdPull = findViewById<RecyclerView>(R.id.pullrequest).apply {

            setHasFixedSize(true)
            layoutManager = viewManagerPull
            adapter = viewAdapterPull
        }

        getPull.buscaPull(owner, repositorio).enqueue(object : Callback<List<ItemPullrequest>> {
            override fun onResponse(
                call: Call<List<ItemPullrequest>>, response: Response<List<ItemPullrequest>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        bindingPull.pullrequest.adapter =
                            PullrequestAdapter(it, this@PullrequestActivity)
                    }
                }
            }


            override fun onFailure(call: Call<List<ItemPullrequest>>, t: Throwable) {
                Log.d("erro inesperado", t.message.toString())
                Toast.makeText(this@PullrequestActivity, "erro", Toast.LENGTH_LONG).show()
            }
        })
    }

}
