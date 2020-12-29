package com.example.desafiogabriela.model

import com.example.desafiogabriela.ItemMain
import com.example.desafiogabriela.ItemPullrequest
import com.google.gson.annotations.SerializedName

data class Itens (
    @SerializedName("items") val items : List<ItemMain>)