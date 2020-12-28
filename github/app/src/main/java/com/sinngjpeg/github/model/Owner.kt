package com.sinngjpeg.github.model

import com.google.gson.annotations.SerializedName


data class Owner(
    @SerializedName("login")
    var nome: String,
    @SerializedName("avatar_url")
    var urlFoto: String,
//    @SerializedName("html_url")
//    var urlSite: String
)