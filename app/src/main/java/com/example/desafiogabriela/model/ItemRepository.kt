package com.example.desafiogabriela.model

import com.google.gson.annotations.SerializedName

data class ItemRepository (

    @SerializedName ("name")var nameRepository: String,
    @SerializedName ("description")var description: String,
    @SerializedName ("forks_count")var forks_count: Int,
    @SerializedName ("stargazers_count") var stars_count: Int,
    @SerializedName ("owner") val owner: Owner,
    @SerializedName ("full_name") var fullname: String)