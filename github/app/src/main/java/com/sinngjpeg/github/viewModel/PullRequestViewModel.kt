package com.sinngjpeg.github.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sinngjpeg.github.model.Owner
import com.sinngjpeg.github.model.PullRequest
import com.sinngjpeg.github.model.Repository
import com.sinngjpeg.github.services.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PullRequestViewModel : ViewModel() {


    val pullRequestLiveData: MutableLiveData<List<PullRequest>> = MutableLiveData()
    val pullRequestError : MutableLiveData<Int> = MutableLiveData()

    fun getPullRequest(owner: String, repository: String) {
        ApiService.service.getPullRequest(owner, repository).enqueue(object : Callback<List<PullRequest>> {

            //200
            override fun onResponse(
                call: Call<List<PullRequest>>,
                response: Response<List<PullRequest>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let { pullRequests ->
                        pullRequestLiveData.value = pullRequests
                    }
                }

            }

            //500
            override fun onFailure(call: Call<List<PullRequest>>, t: Throwable) {
                Log.d("Erro Chamada", t.message.toString())
//                pullRequestError.postValue(t)
            }

        })
    }
}
