package com.sinngjpeg.github.model.data

import com.google.gson.annotations.SerializedName


data class Owner(
    @SerializedName("login") var userName: String,
    @SerializedName("avatar_url") var userPhoto: String
)