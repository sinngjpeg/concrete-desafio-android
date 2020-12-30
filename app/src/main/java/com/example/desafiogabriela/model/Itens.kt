package com.example.desafiogabriela.model

import com.google.gson.annotations.SerializedName

data class Itens (
    @SerializedName("items") val items : List<ItemMain>)