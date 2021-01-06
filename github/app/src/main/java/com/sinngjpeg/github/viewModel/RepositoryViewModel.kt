package com.sinngjpeg.github.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sinngjpeg.github.model.data.ItemRepository
import com.sinngjpeg.github.model.data.Repository
import com.sinngjpeg.github.webservices.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryViewModel : ViewModel() {

    val repositoryLiveData: MutableLiveData<List<Repository>> = MutableLiveData()

    fun getRepositories() {
        RetrofitService.service.getRepositories(2).enqueue(
            object : Callback<ItemRepository> {

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

                override fun onFailure(call: Call<ItemRepository>, t: Throwable) {
                    Log.d("Erro de Chamada", t.message.toString())
                }
            })
    }
}