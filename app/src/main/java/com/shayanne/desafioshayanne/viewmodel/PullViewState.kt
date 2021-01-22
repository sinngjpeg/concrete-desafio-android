package com.shayanne.desafioshayanne.viewmodel

import com.shayanne.desafioshayanne.model.PullRequests

sealed class PullViewState {

    data class Sucesso(val list: List<PullRequests>) : PullViewState()
    data class Erro(val messageError: Int) : PullViewState()
}
