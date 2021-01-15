package com.shayanne.desafioshayanne.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shayanne.desafioshayanne.R
import com.shayanne.desafioshayanne.api.InicializadorRepositories
import com.shayanne.desafioshayanne.api.WebClientResquestPull
import com.shayanne.desafioshayanne.model.ItemsRepositories
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryViewModel(private val callGit: WebClientResquestPull) : ViewModel() {


    //private val callGit by lazy { InicializadorRepositories.webClientGithub/*initRep()*/ }

    private val state = MutableLiveData<RepositoryViewState>()

    // esta é apenas uma LiveData, nao é mutable, pois nao queremos que a activity a altere
    fun getViewState(): LiveData<RepositoryViewState> = state


    fun loadpage(page: Int) {
        // paginacao
        callGit.getRepositories(1).enqueue(object : Callback<ItemsRepositories> {
            override fun onResponse(
                call: Call<ItemsRepositories>,
                response: Response<ItemsRepositories>
            ) {
                if (response.isSuccessful) {
                    Log.d("MainActivity-loadMore", "isSucessfull, page : $page")
                    response.body()?.let {
                        state.postValue(RepositoryViewState.Sucesso(it.items))
                        //RepositoryActivity().repositoryAdapter.addRepositories(it.items)
                    }
                } else {
                    Log.d(
                        "MainActivity-loadMore",
                        "is NOT sucessful - ${response.code()} + ${response.errorBody()?.string()}"
                    )

                }
            }

            override fun onFailure(call: Call<ItemsRepositories>, t: Throwable) {
                state.postValue(RepositoryViewState.Erro(R.string.error_network_request_failed))
                // Toast.makeText(RepositoryActivity(), t.message, Toast.LENGTH_LONG).show()
            }
        })
    }

}

