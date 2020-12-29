package com.sinngjpeg.github.model

import com.google.gson.annotations.SerializedName

data class ItemPullRequest(

    @SerializedName("items") val items: List<ItemPullRequest>

)
