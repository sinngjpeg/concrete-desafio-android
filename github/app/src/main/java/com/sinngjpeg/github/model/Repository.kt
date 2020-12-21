package com.sinngjpeg.github.model

data class Repository(
        val nomeRepository: String,
        val descricaoRepository: String,
        val imgFork: String?,
        val numeroDeForks: Double,
        val imgStar: String?,
        val numeroDeStars: Double,
        val imgPorfile: String?,
        val userName: String,
        val fullName: String


)