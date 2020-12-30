package com.example.desafiogabriela.model


import com.google.gson.annotations.SerializedName

data class ItemPullrequest (

    @SerializedName ("owner") val owner: Owner,
    @SerializedName ("name") val name: String,
    @SerializedName ("description") val description: String,
    @SerializedName ("full_name") val fullname: String,
    @SerializedName ("html_url") val html: String
)