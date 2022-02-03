package com.example.desafiogabriela.repository.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.desafiogabriela.useCase.GetRepositoryUseCase

class RepositoryViewModelFactory(private val getRepositoryUseCase: GetRepositoryUseCase) :
    ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RepositoryViewModel::class.java)) {
            return RepositoryViewModel(getRepositoryUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
