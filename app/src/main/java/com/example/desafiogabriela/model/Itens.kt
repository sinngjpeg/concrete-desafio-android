package com.example.desafiogabriela.model

import com.example.desafiogabriela.ItemMain
import com.google.gson.annotations.SerializedName

data class Itens (
    @SerializedName("items") val itens : List<ItemMain>
){

}