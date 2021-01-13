package com.example.desafiogabriela.features.model

import com.google.gson.annotations.SerializedName

data class Items (
    @SerializedName("items") val items : List<ItemRepository>)