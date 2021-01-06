package com.example.desafiogabriela.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.SyncStateContract
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiogabriela.Constante
import com.example.desafiogabriela.Constante.owner
import com.example.desafiogabriela.Constante.repositorio
import com.example.desafiogabriela.model.ItemPullrequest
import com.example.desafiogabriela.adapter.PullrequestAdapter
import com.example.desafiogabriela.R
import com.example.desafiogabriela.webservice.InicializadorDeRetrofitPull.getPull
import com.example.desafiogabriela.databinding.ActivityPullrequestBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PullrequestActivity : AppCompatActivity(), PullrequestAdapter.ClickListener {

    private val getPull by lazy { getPull() }

    var owner = ""
    var repositorio = ""
    var foto = ""

    private val lista = ArrayList<ItemPullrequest>()
    private val adapter = PullrequestAdapter(lista,this)
    private lateinit var bindingPull : ActivityPullrequestBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        owner = intent.getStringExtra(Constante.owner).toString()
        repositorio = intent.getStringExtra(Constante.repositorio).toString()
        foto = intent.getStringExtra(Constante.foto).toString()

        super.onCreate(savedInstanceState)
        bindingPull = ActivityPullrequestBinding.inflate(layoutInflater)
        setContentView(bindingPull.root)

        setSupportActionBar(bindingPull.pullToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        bindingPull.pullrequest.adapter = adapter
        bindingPull.pullrequest.layoutManager = LinearLayoutManager(this)
        bindingPull.pullrequest.setHasFixedSize(true)


        getPullrequest(owner,repositorio)
    }
    fun getPullrequest (owner: String,repositorio: String){


        getPull.buscaPull(owner, repositorio).enqueue(object : Callback<List<ItemPullrequest>> {
            override fun onFailure(call: Call<List<ItemPullrequest>>, t: Throwable) {
                Log.d("Erro de chamada", t.message.toString())
                Toast.makeText(this@PullrequestActivity, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<List<ItemPullrequest>>, response: Response<List<ItemPullrequest>>) {
                if (response.isSuccessful){
                    response.body()?.let {
                        bindingPull.pullrequest.adapter = PullrequestAdapter(lista,this@PullrequestActivity)
                        lista.addAll(it)
                    }
                }
            }

        })
    }

    override fun setOnClickListener(position: Int) {
        val intentPull= Intent(Intent.ACTION_VIEW, Uri.parse(lista[position].html))
        startActivity(intentPull)
    }


}
