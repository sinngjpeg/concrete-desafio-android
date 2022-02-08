package com.example.desafiogabriela.repository.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.desafiogabriela.R
import com.example.desafiogabriela.model.ItemRepository
import com.example.desafiogabriela.model.Items
import com.example.desafiogabriela.useCase.GetRepositoryUseCase
import com.example.desafiogabriela.useCase.listener.RepositoryResultListener

class RepositoryViewModel(
    private val getRepositoryUseCase: GetRepositoryUseCase,
) : ViewModel() {

    private var page = 1
    private val list = mutableListOf<ItemRepository>()


    private val liveDataListSuccess: MutableLiveData<List<ItemRepository>> = MutableLiveData()
    val liveDataNetworkSuccess: LiveData<List<ItemRepository>> = liveDataListSuccess
    private val liveDataError = MutableLiveData<Int>()
    val liveDataNetworkError: LiveData<Int> = liveDataError

    fun getSearch() {
        getRepositoryUseCase.execute(page,
            onResultListener = object : RepositoryResultListener {
                override fun onSuccess(items: Items) {
                    liveDataListSuccess.value = list
                    list.addAll(items.items)
                }

                override fun onError() {
                    liveDataError.postValue(R.string.error_message)
                }

                override fun onNetworkError() {
                    liveDataError.postValue(R.string.network_error)
                }
            })
    }
}

