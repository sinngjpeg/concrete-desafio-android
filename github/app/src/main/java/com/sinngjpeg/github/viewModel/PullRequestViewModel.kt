package com.sinngjpeg.github.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sinngjpeg.github.model.PullRequest
import com.sinngjpeg.github.services.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PullRequestViewModel : ViewModel() {

    val pullRequestLiveData: MutableLiveData<List<PullRequest>> = MutableLiveData()

    fun getPullRequest() {

        ApiService.serviceRepository.getPullRequest().enqueue(object : Callback<PullRequest> {

            //200
            override fun onResponse(
                call: Call<PullRequest>,
                response: Response<PullRequest>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let { PullRequest ->
                        pullRequestLiveData = PullRequest
                    }
                }

            }

            //500
            override fun onFailure(call: Call<PullRequest>, t: Throwable) {
                Log.d("Erro Chamada", t.message.toString())
            }

        })
    }

}