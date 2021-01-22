package com.shayanne.desafioshayanne.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shayanne.desafioshayanne.api.ApiWebClientRequest

class PullViewModelFactory(private val callGit: ApiWebClientRequest) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PullViewModel::class.java)) {
            return PullViewModel(callGit) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
