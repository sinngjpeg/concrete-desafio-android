package com.sinngjpeg.github.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sinngjpeg.github.model.ItemPullRequest
import com.sinngjpeg.github.model.PullRequest
import com.sinngjpeg.github.services.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PullRequestViewModel : ViewModel() {

    val pullRequestLiveData: MutableLiveData<List<PullRequest>> = MutableLiveData()

//    fun gerPullRequest() {
//        ApiService.service.getPullRequest().enqueue(object : Callback<ItemPullRequest> {
//
//            //200
//            override fun onResponse(
//                call: Call<ItemPullRequest>,
//                response: Response<ItemPullRequest>
//            ) {
//                if (response.isSuccessful) {
//                    response.body()?.let { itemPullRequest ->
//                        pullRequestLiveData.value = itemPullRequest.items
//                    }
//                }
//
//            }
//
//            //500
//            override fun onFailure(call: Call<ItemPullRequest>, t: Throwable) {
//                Log.d("Erro Chamada", t.message.toString())
//            }
//
//        })
//    }

}