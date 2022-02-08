package com.example.desafiogabriela.pull.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.desafiogabriela.pull.useCase.GetPullUseCase

class PullrequestViewModelFactory(private val getPullUseCase: GetPullUseCase) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PullrequestViewModel::class.java)) {
            return PullrequestViewModel(getPullUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
