package com.sinngjpeg.github.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sinngjpeg.github.model.data.PullRequest
import com.sinngjpeg.github.webservices.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PullRequestViewModel : ViewModel() {

    val pullRequestLiveData: MutableLiveData<List<PullRequest>> = MutableLiveData()
    val pullRequestError: MutableLiveData<Int> = MutableLiveData()

    fun getPullRequests(owner: String, repository: String) {
        with(RetrofitService) {
            service.getPullRequests(owner, repository).enqueue(
                object : Callback<List<PullRequest>> {
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
                    override fun onFailure(call: Call<List<PullRequest>>, t: Throwable) {
                        Log.d("Erro de Chamada", t.message.toString())
                    }
                })
        }
    }
}
