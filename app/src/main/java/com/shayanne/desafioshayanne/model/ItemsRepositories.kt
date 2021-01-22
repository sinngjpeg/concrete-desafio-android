package com.shayanne.desafioshayanne.model

import com.google.gson.annotations.SerializedName

data class ItemsRepositories(

    @SerializedName("items") val items: List<RepositoryRequests>

)
