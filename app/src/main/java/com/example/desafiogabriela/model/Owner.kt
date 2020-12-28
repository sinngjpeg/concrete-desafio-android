package com.example.desafiogabriela.model

import com.google.gson.annotations.SerializedName

data class Owner(
    @SerializedName ("avatar_url") val avatar_url: String,
    @SerializedName ("login") val login: String){

}