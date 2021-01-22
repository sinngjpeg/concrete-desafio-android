package com.shayanne.desafioshayanne.viewmodel

import com.shayanne.desafioshayanne.model.PullRequests

sealed class PullViewState {

    class Sucesso(val list: List<PullRequests>) : PullViewState()
    class Erro(val messageError: Int) : PullViewState()
}
