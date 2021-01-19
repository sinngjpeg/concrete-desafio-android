package com.example.desafiogabriela.pull.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.desafiogabriela.api.WebClient

class PullrequestViewModelFactory (private val getPull: WebClient) : ViewModelProvider.Factory{

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PullrequestViewModel::class.java)) {
            return PullrequestViewModel(getPull) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}