package com.example.desafiogabriela.pull.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desafiogabriela.R
import com.example.desafiogabriela.domain.model.ItemPullrequest
import com.example.desafiogabriela.pull.useCase.GetPullUseCase
import kotlinx.coroutines.launch
import java.io.IOException
import java.lang.Exception

class PullrequestViewModel(
    private val getPullUseCase: GetPullUseCase,
) : ViewModel() {

    private val liveDataSuccess: MutableLiveData<List<ItemPullrequest>> = MutableLiveData()
    val liveDataNetworkSuccess: LiveData<List<ItemPullrequest>> = liveDataSuccess
    private val liveDataError = MutableLiveData<Int>()
    val liveDataNetworkError: LiveData<Int> = liveDataError
    private val list = mutableListOf<ItemPullrequest>()

    fun getSearchPull(owner: String, repository: String) {
        viewModelScope.launch {
            try {
                val result = getPullUseCase.execute(owner, repository)
                liveDataSuccess.value = list
                list.addAll(result)

            } catch (ex: IOException) {
                liveDataError.postValue(R.string.network_error)
            } catch (ex: Exception) {
                liveDataError.postValue(R.string.error_message)
            }
        }
    }
}
