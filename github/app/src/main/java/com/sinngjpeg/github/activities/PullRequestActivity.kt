package com.sinngjpeg.github.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sinngjpeg.github.R

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