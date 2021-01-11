package com.sinngjpeg.github.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sinngjpeg.github.R
import com.sinngjpeg.github.adapter.RepositoryAdapter
import com.sinngjpeg.github.model.data.Repository
import com.sinngjpeg.github.viewModel.RepositoryViewModel
import kotlinx.android.synthetic.main.pull_request_activity.*
import kotlinx.android.synthetic.main.repository_activity.*

class RepositoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.repository_activity)

        val adapterRepositoy = RepositoryAdapter(List(Repository), this)
        var page = 1
        val isLoading = false
        var limit = 10


        val viewModel: RepositoryViewModel =
            ViewModelProviders.of(this).get(RepositoryViewModel::class.java)
        viewModel.repositoryLiveData.observe(this, Observer {
            it?.let { repository ->
                with(recycle_view_repository_list) {
                    layoutManager = LinearLayoutManager(
                        this@RepositoryActivity,
                        RecyclerView.VERTICAL,
                        false
                    )
                    setHasFixedSize(true)
                    adapter = RepositoryAdapter(repository) { repository ->
                        val intent = PullRequestActivity.getStartIntent(
                            this@RepositoryActivity,
                            repository.title,
                            repository.owner.userName
                        )
                        this@RepositoryActivity.startActivity(intent)
                    }
                }
            }
        })
        viewModel.getRepositories(page)




        fun onScrollListener(){
            recycle_view_repository_list.addOnScrollListener(
                object : RecyclerView.OnScrollListener(){
                    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                        super.onScrollStateChanged(recyclerView, newState)
                        val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                        val lastItem = layoutManager.findLastVisibleItemPosition()
                        if (!isLoading){
                            if(lastItem==adapterRepositoy.repository.size-1){
                                limit = adapterRepositoy.repository.size+1
                                page+=1
                                viewModel.getRepositories(page)
                            }
                        }
                    }
                }
            )
        }
    }
}





