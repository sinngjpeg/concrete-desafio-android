package com.example.desafiogabriela.pull

import android.content.ClipData
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafiogabriela.api.InicializadorDeRetrofit
import com.example.desafiogabriela.utils.Constante
import com.example.desafiogabriela.model.ItemPullrequest
import com.example.desafiogabriela.databinding.ActivityPullrequestBinding
import com.example.desafiogabriela.pull.viewmodel.PullrequestViewModel
import com.example.desafiogabriela.pull.viewmodel.PullrequestViewModelFactory


class PullrequestActivity : AppCompatActivity(), PullrequestAdapter.ClickListener {

    private var owner = ""
    private var repositorio = ""
    private var foto = ""

    private val pullViewModel : PullrequestViewModel by viewModels {
        PullrequestViewModelFactory(InicializadorDeRetrofit.get())
    }

    private val lista = ArrayList<ItemPullrequest>()
    private val pullAdapter = PullrequestAdapter(lista,this)
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

        bindingPull.pullrequest.adapter = pullAdapter
        bindingPull.pullrequest.layoutManager = LinearLayoutManager(this)
        bindingPull.pullrequest.setHasFixedSize(true)
        bindingPull.pullToolbar.title = repositorio

        pullView()
        pullViewModel.getPull(owner, repositorio)
    }

    private fun pullView(){
        pullViewModel.pullLiveData.observe(this, Observer {

            pullAdapter.list = it
            pullAdapter.notifyDataSetChanged()

        })
    }

    override fun setOnClickListener(itemClick: ItemPullrequest) {
        val intentPull= Intent(Intent.ACTION_VIEW, Uri.parse(itemClick.html))
        startActivity(intentPull)
    }
}