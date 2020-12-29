package com.example.desafiogabriela

import com.google.gson.annotations.SerializedName
import com.example.desafiogabriela.model.Owner

data class ItemPullrequest (

    @SerializedName ("owner") val owner: Owner,
    @SerializedName ("name") val name: String,
    @SerializedName ("description") val description: String,
    @SerializedName ("fullname") val fullname: String)