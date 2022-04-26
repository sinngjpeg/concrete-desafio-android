package com.example.desafiogabriela.repository.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desafiogabriela.R
import com.example.desafiogabriela.domain.model.ItemRepository
import com.example.desafiogabriela.repository.useCase.GetRepositoryUseCase
import com.example.desafiogabriela.utils.log.Logger
import kotlinx.coroutines.launch
import java.io.IOException

class RepositoryViewModel(
    private val getRepositoryUseCase: GetRepositoryUseCase,
    private val logger: Logger
) : ViewModel() {

    private var page = 1
    private val list = mutableListOf<ItemRepository>()


    private val liveDataListSuccess: MutableLiveData<List<ItemRepository>> = MutableLiveData()
    val liveDataNetworkSuccess: LiveData<List<ItemRepository>> = liveDataListSuccess
    private val liveDataError = MutableLiveData<Int>()
    val liveDataNetworkError: LiveData<Int> = liveDataError

    fun getSearch() {

        viewModelScope.launch {
            try {
                val result = getRepositoryUseCase.execute(page)
                liveDataListSuccess.value = list
                list.addAll(result.items)
            } catch (ex: IOException) {
                liveDataError.postValue(R.string.network_error)
                logger.logMessage("repo", ex.stackTraceToString())
            } catch (ex: Exception) {
                logger.logMessage("repo", ex.stackTraceToString())
                liveDataError.postValue(R.string.error_message)
            }
        }
    }
}

