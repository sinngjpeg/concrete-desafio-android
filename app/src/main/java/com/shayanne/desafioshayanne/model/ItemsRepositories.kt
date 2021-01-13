package com.shayanne.desafioshayanne.model

import com.google.gson.annotations.SerializedName
import com.shayanne.desafioshayanne.model.RepositoryRequests

class ItemsRepositories (

    @SerializedName("items") val items: List<RepositoryRequests>

)