package com.sinngjpeg.github.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sinngjpeg.github.R
import com.sinngjpeg.github.adapter.PullRequestAdapter
import com.sinngjpeg.github.viewModel.PullRequestViewModel
import kotlinx.android.synthetic.main.item_pullrequest.*
import kotlinx.android.synthetic.main.pull_request_activity.*
import kotlinx.android.synthetic.main.repository_activity.*

class PullRequestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pull_request_activity)
        setSupportActionBar(findViewById(R.id.toolbar_pullrequest) )
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val title = intent.getStringExtra(EXTRA_TITLE)
        val proprietario = intent.getStringExtra(EXTRA_PROPRIETARIO)

        val viewModel: PullRequestViewModel =
            ViewModelProviders.of(this).get(PullRequestViewModel::class.java)
        viewModel.pullRequestLiveData.observe(this, Observer {
            it?.let { pullRequests ->
                with(recycle_view_pullrequest_list) {
                    layoutManager = LinearLayoutManager(
                        this@PullRequestActivity,
                        RecyclerView.VERTICAL,
                        false
                    )
                    setHasFixedSize(true)
                    adapter = PullRequestAdapter(pullRequests)
                }
            }
        })
        if (title != null && proprietario != null) viewModel.getPullRequests(proprietario, title)
    }


    companion object {
        private const val EXTRA_TITLE = "EXTRA_TITLE"
        private const val EXTRA_PROPRIETARIO = "EXTRA_PROPRIETARIO"

        fun getStartIntent(
            context: Context,
            title: String,
            proprietario: String
        ): Intent {
            return Intent(context, PullRequestActivity::class.java).apply {
                putExtra(EXTRA_TITLE, title)
                putExtra(EXTRA_PROPRIETARIO, proprietario)
            }
        }
    }
}
