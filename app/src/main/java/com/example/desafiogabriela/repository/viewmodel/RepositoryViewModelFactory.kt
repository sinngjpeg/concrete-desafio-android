package com.example.desafiogabriela.repository.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.desafiogabriela.api.WebClient

class RepositoryViewModelFactory(private val get: WebClient) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RepositoryViewModel::class.java)) {
            return RepositoryViewModel(get) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
