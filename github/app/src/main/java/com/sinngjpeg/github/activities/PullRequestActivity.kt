package com.sinngjpeg.github.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sinngjpeg.github.R
import com.sinngjpeg.github.adapter.PullRequestAdapter
import com.sinngjpeg.github.viewModel.PullRequestViewModel
import kotlinx.android.synthetic.main.pull_request_activity.*
import kotlinx.android.synthetic.main.repository_activity.*

class PullRequestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pull_request_activity)

        setSupportActionBar(findViewById(R.id.toolbar_pullrequest))
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val viewModel: PullRequestViewModel =
            ViewModelProviders.of(this).get(PullRequestViewModel::class.java)

        viewModel.pullRequestLiveData.observe(this, Observer {
            it?.let { pullrequest ->
                with(recycle_view_pullrequest_list) {
                    layoutManager =
                        LinearLayoutManager(this@PullRequestActivity, RecyclerView.VERTICAL, false)
                    //itens da lista tem o tamanho fixo
                    setHasFixedSize(true)
                    adapter = PullRequestAdapter(pullrequest)
                }
            }
        })

       viewModel.pullRequestLiveData

    }

}