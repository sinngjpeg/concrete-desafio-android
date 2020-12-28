package com.sinngjpeg.github.services

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sinngjpeg.github.model.ItemRepository
import com.sinngjpeg.github.model.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryViewModel : ViewModel() {

    val repositoryLiveData: MutableLiveData<List<Repository>> = MutableLiveData()

    fun getRepository() {
        //repositoryLiveData.value = createRepositoryFake()
        ApiService.service.getRepositories().enqueue(object: Callback<ItemRepository>{

            //200
            override fun onResponse(call: Call<ItemRepository>, response: Response<ItemRepository>) {
                if (response.isSuccessful){
                    val repositorylist : MutableList<ItemRepository> = mutableListOf()
                    response.body()?.let { itemRepository ->
                       for (items in ItemRepository)


                    }
                }


            }
            //500
            override fun onFailure(call: Call<Repository>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    fun createRepositoryFake() : List<Repository> {
        return listOf(
            Repository(1,"nome","descricao", "", 222,2222)
        )
    }
}