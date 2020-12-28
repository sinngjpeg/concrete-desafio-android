package com.sinngjpeg.github.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.sinngjpeg.github.R
import com.sinngjpeg.github.adapter.RepositoryAdapter
import com.sinngjpeg.github.services.PullRequestViewModel

class PullRequestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pull_request_activity)

        setSupportActionBar(findViewById(R.id.toolbar_pullrequest))
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

//        val viewModel: PullRequestViewModel =
//            ViewModelProviders.of(this).get(PullRequestViewModel::class.java)
//
//        viewModel.pullRequestLiveData.observe(this, Observer {
//            it?.let { pullrequest ->
//                val recyclerView = findViewById<RecyclerView>(R.id.recycle_view_pullrequest_list)
//                val adapter = RepositoryAdapter(pullrequest)
//                recyclerView.adapter = adapter
//            }
//        })
//
//        viewModel.getRepository()
//
  }

}