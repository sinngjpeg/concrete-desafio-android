package com.sinngjpeg.github.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sinngjpeg.github.R
import com.sinngjpeg.github.adapter.RepositoryAdapter
import com.sinngjpeg.github.viewModel.RepositoryViewModel
import kotlinx.android.synthetic.main.pull_request_activity.*
import kotlinx.android.synthetic.main.repository_activity.*

class RepositoryActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.repository_activity)


        val viewModel: RepositoryViewModel =
            ViewModelProviders.of(this).get(RepositoryViewModel::class.java)

        //escutando pelo livedata
        viewModel.repositoryLiveData.observe(this, Observer {
            it?.let { repository ->
                with(recycle_view_repository_list) {
                    layoutManager =
                        LinearLayoutManager(this@RepositoryActivity, RecyclerView.VERTICAL, false)
                    //itens da lista tem o tamanho fixo
                    setHasFixedSize(true)
                    adapter = RepositoryAdapter(repository)
                }
            }
        })

        viewModel.getRepository()
    }


}



