package com.example.desafiogabriela.domain.model

import com.google.gson.annotations.SerializedName

data class Items(
    @SerializedName("items")
    val items: List<ItemRepository>,
)
