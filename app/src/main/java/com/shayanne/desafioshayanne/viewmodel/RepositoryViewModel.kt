package com.shayanne.desafioshayanne.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModel
import com.shayanne.desafioshayanne.R
import com.shayanne.desafioshayanne.api.InicializadorRepositories
import com.shayanne.desafioshayanne.model.ItemsRepositories
import com.shayanne.desafioshayanne.repository.RepositoryActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryViewModel : ViewModel() {

    /*private val callGit by lazy { InicializadorRepositories.initRep() }

    private fun loadPage(page:Int) {
        Log.d("MainActivity-loadMore", "loading page $page")

        fun tryAgain(){
            AlertDialog.Builder(RepositoryActivity())
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
                    Log.d("MainActivity-loadMore", "isSucessfull, page : $page" )
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
                Toast.makeText(RepositoryActivity(), t.message, Toast.LENGTH_LONG).show()
            }
        })
    }
*/

//    private val callGit by lazy { InicializadorRepositories.webClientGithub/*initRep()*/ }



}