package com.example.desafiogabriela

import com.example.desafiogabriela.model.Owner
import com.google.gson.annotations.SerializedName

data class ItemMain (

    @SerializedName ("name")var name: String,
    @SerializedName ("description")var description: String,
    @SerializedName ("forks_count")var forks_count: Int,
    @SerializedName ("stargazers_count") var stars_count: Int,
    @SerializedName ("owner") val owner: Owner,
    @SerializedName ("full_name") var fullname: String)