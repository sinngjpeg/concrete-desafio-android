package com.sinngjpeg.github.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.sinngjpeg.github.R
import com.sinngjpeg.github.adapter.PullRequestAdapter
import com.sinngjpeg.github.adapter.RepositoryAdapter
import com.sinngjpeg.github.model.PullRequest

class PullRequestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pull_request_activity)

        setSupportActionBar(findViewById(R.id.toolbar_pullrequest))
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val intencao = Intent(this, RepositoryActivity::class.java)
        startActivity(intencao)

        val recyclerView = findViewById<RecyclerView>(R.id.recycle_view_pullrequest_list)

        val item1 =
            PullRequest("Repositorio1", "descricao1", "", "sinng", "ingrid")


        val listPullRequest = listOf<PullRequest>(
            item1
        )

        val adapter = PullRequestAdapter(listPullRequest)
        recyclerView.adapter = adapter
    }
}