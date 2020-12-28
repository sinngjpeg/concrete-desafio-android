package com.sinngjpeg.github.activities

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.sinngjpeg.github.R
import com.sinngjpeg.github.adapter.RepositoryAdapter
import com.sinngjpeg.github.model.Item
import com.sinngjpeg.github.services.ApiService.initRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryActivity : AppCompatActivity() {

    private val client by lazy { initRetrofit() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.repository_activity)


        client.getRepositories().enqueue(object : Callback<Item> {
            override fun onResponse(
                call: Call<Item>,
                response: Response<Item>
            ) {
                val recyclerViewRepository =
                    findViewById<RecyclerView>(R.id.recycle_view_repository_list)
//                val adapter = RepositoryAdapter()
                if (response.isSuccessful) {
                    response.body()?.let {

                        recyclerViewRepository.adapter = RepositoryAdapter(it.itens)

                    }
                }

            }

            override fun onFailure(call: Call<Item>, t: Throwable) {
                Log.d("falhou?", t.message.toString())
                Toast.makeText(
                    this@RepositoryActivity,t.message,Toast.LENGTH_SHORT).show()
            }
        })

//        val viewModel: RepositoryViewModel =
//            ViewModelProviders.of(this).get(RepositoryViewModel::class.java)
//
//        viewModel.repositoryLiveData.observe(this, Observer {
//            it?.let { repository ->
//                val recyclerView = findViewById<RecyclerView>(R.id.recycle_view_repository_list)
//                val adapter = RepositoryAdapter(repository)
//                recyclerView.adapter = adapter
//            }
//        })

//        viewModel.getRepository()

    }


}


