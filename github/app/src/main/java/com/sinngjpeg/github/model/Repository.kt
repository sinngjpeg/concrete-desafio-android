package com.sinngjpeg.github.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class Repository(

    @SerializedName("total_count")
    val totalPaginas: Int,
    @SerializedName("name")
    var nomeRepository: String,
    @SerializedName("description")
    val descricaoRepository: String,
    @SerializedName("owner")
    val proprietario: String,
    @SerializedName("forks_count")
    val numeroDeStars: Long,
    @SerializedName("forks")
    val numeroDeForks: Long
)