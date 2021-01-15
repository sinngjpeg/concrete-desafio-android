package com.example.desafiogabriela.repository.viewmodel


import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiogabriela.repository.RepositoryActivity
import com.example.desafiogabriela.model.ItemRepository
import com.example.desafiogabriela.model.Items
import com.example.desafiogabriela.api.InicializadorDeRetrofit.get
import com.example.desafiogabriela.api.WebClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryViewModel (private val get: WebClient): ViewModel() {

    var page = 1

    private val liveDataListSuccess : MutableLiveData<List<ItemRepository>> = MutableLiveData()
    val liveData : LiveData<List<ItemRepository>> = liveDataListSuccess

    private val liveDataError = MutableLiveData<Any>()
    private val list = mutableListOf<ItemRepository>()


    fun getSearch() {

        Log.d("Repositorio ViewModel", "$page")
        get.busca(page).enqueue(object : Callback<Items> {
            override fun onResponse(
                call: Call<Items>, response: Response<Items>
            ) {

                if (response.isSuccessful) {
                    response.body()?.let {

                        list.addAll(it.items)
                        liveDataListSuccess.value = list
                        page++

                    }
                }
            }

            override fun onFailure(call: Call<Items>, t: Throwable) {
                Log.d("erro inesperado", t.message.toString())
                Toast.makeText(RepositoryActivity(), "error", Toast.LENGTH_LONG).show()
                liveDataError.postValue(t)
            }
        })
    }
}