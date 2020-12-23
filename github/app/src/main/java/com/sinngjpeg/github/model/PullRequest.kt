package com.sinngjpeg.github.model

data class PullRequest(
    val nomeRepository: String,
    val descricaoRepository: String,
    val imgPorfile: String?,
    val userName: String,
    val fullName: String
)