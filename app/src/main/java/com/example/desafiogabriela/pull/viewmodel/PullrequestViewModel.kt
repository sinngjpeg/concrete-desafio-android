package com.example.desafiogabriela.pull.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.desafiogabriela.R
import com.example.desafiogabriela.model.ItemPullrequest
import com.example.desafiogabriela.useCase.GetPullUseCase
import com.example.desafiogabriela.useCase.listener.PullResultListener

class PullrequestViewModel(
    private val getPullUseCase: GetPullUseCase,
) : ViewModel() {

    private val liveDataSuccess: MutableLiveData<List<ItemPullrequest>> = MutableLiveData()
    val liveDataNetworkSuccess: LiveData<List<ItemPullrequest>> = liveDataSuccess
    private val liveDataError = MutableLiveData<Int>()
    val liveDataNetworkError: LiveData<Int> = liveDataError
    private var owner = ""
    private var repository = ""

    fun getSearchPull() {
        getPullUseCase.execute(owner, repository,
            onResultListener = object : PullResultListener {
                override fun onSuccess(items: List<ItemPullrequest>) {
                    liveDataSuccess.value
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
