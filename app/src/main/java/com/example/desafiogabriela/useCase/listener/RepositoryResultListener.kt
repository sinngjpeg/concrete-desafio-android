package com.example.desafiogabriela.useCase.listener

import com.example.desafiogabriela.model.Items

interface RepositoryResultListener {
    fun onSuccess(items: Items)
    fun onError()
}