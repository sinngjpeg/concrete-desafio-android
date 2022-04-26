package com.example.desafiogabriela.pull

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafiogabriela.api.RetrofitLauncher
import com.example.desafiogabriela.utils.Constant
import com.example.desafiogabriela.domain.model.ItemPullrequest
import com.example.desafiogabriela.databinding.ActivityPullrequestBinding
import com.example.desafiogabriela.pull.viewmodel.PullrequestViewModel
import com.example.desafiogabriela.pull.viewmodel.PullrequestViewModelFactory
import com.example.desafiogabriela.pull.useCase.GetPullUseCase

class PullrequestActivity : AppCompatActivity(), PullrequestAdapter.ClickListener {

    private val pullViewModel: PullrequestViewModel by viewModels {
        PullrequestViewModelFactory(GetPullUseCase(RetrofitLauncher.get()))
    }

    private val list = ArrayList<ItemPullrequest>()
    private val pullAdapter = PullrequestAdapter(list, this)
    private lateinit var bindingPull: ActivityPullrequestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingPull = ActivityPullrequestBinding.inflate(layoutInflater)
        setContentView(bindingPull.root)

        setSupportActionBar(bindingPull.pullToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val owner = intent.getStringExtra(Constant.owner).toString()
        val repository = intent.getStringExtra(Constant.repository).toString()

        bindingPull.pullrequest.adapter = pullAdapter
        bindingPull.pullrequest.layoutManager = LinearLayoutManager(this)
        bindingPull.pullrequest.setHasFixedSize(true)
        bindingPull.pullToolbar.title = repository

        pullView()
        pullViewModel.getSearchPull(owner, repository)
    }

    private fun pullView() {
        pullViewModel.liveDataNetworkSuccess.observe(this) {
            pullAdapter.list = it
            pullAdapter.notifyDataSetChanged()
        }

        pullViewModel.liveDataNetworkError.observe(this) {
            showError(it)
        }
    }

    private fun showError(@StringRes errorRes: Int) {
        AlertDialog.Builder(this)
            .setMessage(errorRes)
            .show()
    }

    override fun setOnClickListener(itemClick: ItemPullrequest) {
        val intentPull = Intent(Intent.ACTION_VIEW, Uri.parse(itemClick.html))
        startActivity(intentPull)
    }
}
