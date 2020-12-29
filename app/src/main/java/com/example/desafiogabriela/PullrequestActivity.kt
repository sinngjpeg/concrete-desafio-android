package com.example.desafiogabriela

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiogabriela.api.InicializadorDeRetrofitPull.getPull
import com.example.desafiogabriela.databinding.ActivityPullrequestBinding
import com.example.desafiogabriela.model.Itens
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PullrequestActivity: AppCompatActivity() {

    private val getPull by lazy { getPull() }

    private lateinit var bindingPull: ActivityPullrequestBinding
    private lateinit var viewAdapterPull: RecyclerView.Adapter<*>
    private lateinit var recycleViewIdPull: RecyclerView
    private lateinit var viewManagerPull: RecyclerView.LayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingPull = ActivityPullrequestBinding.inflate(layoutInflater)
        setContentView(bindingPull.root)

        setSupportActionBar(findViewById(R.id.pull_toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewAdapterPull = NotePullrequestAdapter(emptyList(), this)
        viewManagerPull = LinearLayoutManager(this)

        recycleViewIdPull = findViewById<RecyclerView>(R.id.pullrequest).apply {

            setHasFixedSize(true)
            layoutManager = viewManagerPull
            adapter = viewAdapterPull
        }

        getPull.buscaPull().enqueue(object : Callback<ItensPull> {
            override fun onResponse(
                call: Call<ItensPull>, response: Response<ItensPull>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        bindingPull.pullrequest.adapter =
                            NotePullrequestAdapter(it.itemsPull, this@PullrequestActivity)
                    }
                }
            }


            override fun onFailure(call: Call<ItensPull>, t: Throwable) {
                Log.d("erro inesperado", t.message.toString())
                Toast.makeText(this@PullrequestActivity, "erro", Toast.LENGTH_LONG).show()
            }
        })
    }

}
