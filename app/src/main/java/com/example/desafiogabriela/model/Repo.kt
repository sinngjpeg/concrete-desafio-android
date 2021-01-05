package com.example.desafiogabriela.model

import com.google.gson.annotations.SerializedName

data class Repo (
    @SerializedName ("name") val nameRepo: String
)