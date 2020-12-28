package com.sinngjpeg.github.model

import com.google.gson.annotations.SerializedName


data class ItemRepository(

    @SerializedName("items") val items: List<Repository>
)
