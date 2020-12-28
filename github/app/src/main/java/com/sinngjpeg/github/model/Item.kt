package com.sinngjpeg.github.model

import com.google.gson.annotations.SerializedName

data class Item(

    @SerializedName("item")
    val itens: List<RepositoryModel>
)
