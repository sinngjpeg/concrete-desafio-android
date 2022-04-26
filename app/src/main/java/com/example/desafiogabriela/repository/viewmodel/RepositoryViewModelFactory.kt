package com.example.desafiogabriela.repository.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.desafiogabriela.repository.useCase.GetRepositoryUseCase
import com.example.desafiogabriela.utils.log.Logger

class RepositoryViewModelFactory(private val getRepositoryUseCase: GetRepositoryUseCase, private val logger: Logger) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RepositoryViewModel::class.java)) {
            return RepositoryViewModel(getRepositoryUseCase, logger ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
