package com.example.desafiogabriela.repository.useCase.listener

import com.example.desafiogabriela.model.Items

interface RepositoryResultListener {
    fun onSuccess(items: Items)
    fun onError()
    fun onNetworkError()
}