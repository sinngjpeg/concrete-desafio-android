package com.sinngjpeg.github.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sinngjpeg.github.model.ItemRepository
import com.sinngjpeg.github.model.Repository
import com.sinngjpeg.github.services.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryViewModel : ViewModel() {

    val repositoryLiveData: MutableLiveData<List<Repository>> = MutableLiveData()

    fun getRepository() {
        ApiService.serviceRepository.getRepositories().enqueue(object : Callback<ItemRepository> {

            //200
            override fun onResponse(
                call: Call<ItemRepository>,
                response: Response<ItemRepository>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let { itemRepository ->
                        repositoryLiveData.value = itemRepository.items
                    }
                }

            }

            //500
            override fun onFailure(call: Call<ItemRepository>, t: Throwable) {
                Log.d("Erro Chamada", t.message.toString())
            }

        })
    }
}