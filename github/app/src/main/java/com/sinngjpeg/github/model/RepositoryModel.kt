package com.sinngjpeg.github.model

import com.google.gson.annotations.SerializedName


data class RepositoryModel(

    @SerializedName("name")
    var nomeRepository: String,
    @SerializedName("description")
    val descricaoRepository: String,



    @SerializedName("name")
    val numeroDeForks: Int,
    @SerializedName("name")
    val numeroDeStars: Int,
    @SerializedName("name")
    val imgPorfile: String?,
    @SerializedName("")
    val userName: String,
    @SerializedName("fullname")
    val fullName: String
)