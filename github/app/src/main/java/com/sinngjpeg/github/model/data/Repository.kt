package com.sinngjpeg.github.model.data

import com.google.gson.annotations.SerializedName


data class Repository(
    @SerializedName("total_count") val totalPages: Int,
    @SerializedName("name") var title: String,
    @SerializedName("description") val description: String,
    @SerializedName("owner") val owner: Owner,
    @SerializedName("forks_count") val qntForks: Long,
    @SerializedName("stargazers_count") val qntStars: Long
)