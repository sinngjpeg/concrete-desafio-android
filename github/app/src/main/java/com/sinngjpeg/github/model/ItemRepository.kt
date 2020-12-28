package com.sinngjpeg.github.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ItemRepository(

    @SerializedName("items")
    val items: List<Repository>
)
