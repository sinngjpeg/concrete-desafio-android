package com.example.desafiogabriela

import com.google.gson.annotations.SerializedName

data class ItensPull(
    @SerializedName("items" ) val itemsPull: List<ItemPullrequest>
)