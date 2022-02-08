package com.example.desafiogabriela.pull.useCase.listener

import com.example.desafiogabriela.model.ItemPullrequest

interface PullResultListener {
    fun onSuccess(items: List<ItemPullrequest>)
    fun onError()
    fun onNetworkError()
}