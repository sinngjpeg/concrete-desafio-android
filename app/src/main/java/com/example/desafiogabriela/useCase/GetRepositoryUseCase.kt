package com.example.desafiogabriela.useCase

import com.example.desafiogabriela.api.WebClient
import com.example.desafiogabriela.model.Items
import com.example.desafiogabriela.useCase.listener.RepositoryResultListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetRepositoryUseCase(
    private val get: WebClient,
) {

    fun execute(
        page: Int,
        onResultListener: RepositoryResultListener,
    ) {
        get.search(page).enqueue(object : Callback<Items> {
            override fun onFailure(
                call: Call<Items>,
                t: Throwable,
            ) {
                onResultListener.onError()
            }

            override fun onResponse(
                call: Call<Items>,
                response: Response<Items>,
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
