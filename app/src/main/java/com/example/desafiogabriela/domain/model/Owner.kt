package com.example.desafiogabriela.domain.model

import com.google.gson.annotations.SerializedName

data class Owner(
    @SerializedName("avatar_url") val image: String,
    @SerializedName("login") val username: String,
)
