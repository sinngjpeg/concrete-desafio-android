package com.shayanne.desafioshayanne.activity

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shayanne.desafioshayanne.EndlessRecyclerViewScrollListener
import com.shayanne.desafioshayanne.R
import com.shayanne.desafioshayanne.adapter.PullAdapter
import com.shayanne.desafioshayanne.adapter.RepositoryAdapter
import com.shayanne.desafioshayanne.databinding.ActivityMainBinding
import com.shayanne.desafioshayanne.modelo.ItemsRepositories
import com.shayanne.desafioshayanne.modelo.Repository
import com.shayanne.desafioshayanne.webservices.InicializadorRepositories.initRep
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity() : AppCompatActivity(), RepositoryAdapter.ItemClickListener{

    var isLoading:Boolean = true
    var page = 1

    private val callGit by lazy { initRep() }
    private lateinit var binding: ActivityMainBinding

    private lateinit var idDoRecycleViewRequest: RecyclerView
    private lateinit var viewManager: RecyclerView.LayoutManager
    private val repositoryAdapter = RepositoryAdapter(ArrayList(),this)
   //private val pullAdapter = PullAdapter(ArrayList(),PullActivity())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewManager = LinearLayoutManager(this)
      //  viewAdapter = MeuAdapter(minhalista)

        idDoRecycleViewRequest = findViewById<RecyclerView>(R.id.recyclerview_id).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = repositoryAdapter
        }




          idDoRecycleViewRequest.addOnScrollListener(object : EndlessRecyclerViewScrollListener(
              viewManager as LinearLayoutManager){
              override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
                  loadPage(page)
              }
          })

        loadPage(1)
    }

    private fun loadPage(page:Int) {
        Log.d("MainActivity-loadMore", "loading page $page")

        fun tryAgain(){
            AlertDialog.Builder(this@MainActivity)
                .setMessage(R.string.error_network_request_failed)
                .setPositiveButton(android.R.string.ok ){ _, _ ->
                    loadPage(page)
                }
                .show()
        }

        callGit.getRepositories(page).enqueue(object : Callback<ItemsRepositories> {
            override fun onResponse(
                call: Call<ItemsRepositories>,
                response: Response<ItemsRepositories>
            ) {
                if (response.isSuccessful) {
                    Log.d("MainActivity-loadMore", "isSucessfull")
                    response.body()?.let {
                        repositoryAdapter.addRepositories(it.items)
                    }
                }else{
                    Log.d("MainActivity-loadMore", "is NOT sucessful - ${response.code()} + ${response.errorBody()?.string()}")
                    tryAgain()
                }
            }
            override fun onFailure(call: Call<ItemsRepositories>, t: Throwable) {
                tryAgain()
                Log.d("MainActivity-loadMore", "error")
                Log.d("Erro", t.message.toString())
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }


    override fun CreateIntentClick(position: Int) {
        //passa o Intent pra chamar o DetalheRepositorio, e o startActivity pra mostra-la na tela
        val intent = Intent(this, PullActivity::class.java)
        intent.putExtra(PullActivity.owner, repositoryAdapter.minhalista[position].donoRep.username_rep)
        intent.putExtra(PullActivity.picture, repositoryAdapter.minhalista[position].donoRep.user_rep)
        intent.putExtra(PullActivity.repositorio, repositoryAdapter.minhalista[position].nome_repositorio)
       //intent.putExtra(PullActivity.nome,pullAdapter.minhalistapull[position].nome_completo_pull )
        startActivity(intent)//passar o nome do reposito e do usuario
    }



}





