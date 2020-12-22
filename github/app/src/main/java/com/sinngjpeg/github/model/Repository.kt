package com.sinngjpeg.github.model

data class Repository(
        val nomeRepository: String,
        val descricaoRepository: String,
        val imgFork: String?,
        val numeroDeForks: Int,
        val imgStar: String?,
        val numeroDeStars: Int,
        val imgPorfile: String?,
        val userName: String,
        val fullName: String
)