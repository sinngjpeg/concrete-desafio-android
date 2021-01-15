package com.shayanne.desafioshayanne.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shayanne.desafioshayanne.api.WebClientResquestPull

class RepositoryViewModelFactory(private val callGit: WebClientResquestPull) :
    ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RepositoryViewModel::class.java)) {
            return RepositoryViewModel(callGit) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
