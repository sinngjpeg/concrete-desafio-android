package com.example.desafiogabriela.pull.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.desafiogabriela.model.ItemPullrequest
import com.example.desafiogabriela.api.WebClient
import com.example.desafiogabriela.pull.PullrequestActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PullrequestViewModel (private val getPull: WebClient) : ViewModel() {

    private val pullLiveDataSuccess: MutableLiveData<List<ItemPullrequest>> = MutableLiveData()
    val pullLiveData: LiveData<List<ItemPullrequest>> = pullLiveDataSuccess
    private val pullLiveDataError = MutableLiveData<Any>()

    fun getPull(owner: String, repository: String) {
        getPull.searchPull(owner, repository).enqueue(object : Callback<List<ItemPullrequest>> {

            override fun onFailure(
                call: Call<List<ItemPullrequest>>, t: Throwable
            ) {
                Log.d("Error", t.message.toString())
                Toast.makeText(PullrequestActivity(), t.message, Toast.LENGTH_LONG).show()
                pullLiveDataError.postValue(t)
            }

            override fun onResponse(
                call: Call<List<ItemPullrequest>>,
                response: Response<List<ItemPullrequest>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        pullLiveDataSuccess.postValue(it)
                    }
                }
                else{
                    Throwable(response.errorBody()?.string())

                }
            }

        })
    }
}