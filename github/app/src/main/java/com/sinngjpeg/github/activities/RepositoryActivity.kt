package com.sinngjpeg.github.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.sinngjpeg.github.R
import com.sinngjpeg.github.adapter.RepositoryAdapter

class RepositoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.repository_activity)


        val viewModel: RepositoryViewModel =
            ViewModelProviders.of(this).get(RepositoryViewModel::class.java)

        viewModel.repositoryLiveData.observe(this, Observer {
            it?.let { repository ->
                val recyclerView = findViewById<RecyclerView>(R.id.recycle_view_repository_list)
                val adapter = RepositoryAdapter(repository)
                recyclerView.adapter = adapter
            }
        })

        viewModel.getRepository()


//        // onde vai receber as informacoes da API
//        val adapter = RepositoryAdapter(listRepository)
//        recyclerView.adapter = adapter

    }


}