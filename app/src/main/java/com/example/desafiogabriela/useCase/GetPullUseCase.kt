package com.example.desafiogabriela.useCase

import com.example.desafiogabriela.api.GitHubAPIService
import com.example.desafiogabriela.model.ItemPullrequest
import com.example.desafiogabriela.useCase.listener.PullResultListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetPullUseCase(
    private val apiService: GitHubAPIService,
) {
    fun execute(
        owner: String,
        repository: String,
        onResultListener: PullResultListener,
    ) {
        apiService.searchPull(owner, repository).enqueue(object : Callback<List<ItemPullrequest>> {

            override fun onFailure(
                call: Call<List<ItemPullrequest>>,
                t: Throwable,
            ) {
                onResultListener.onNetworkError()
            }

            override fun onResponse(
                call: Call<List<ItemPullrequest>>,
                response: Response<List<ItemPullrequest>>,
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        onResultListener.onSuccess(it)
                    }
                } else {
                    onResultListener.onError()
                }
            }
        })
    }
}