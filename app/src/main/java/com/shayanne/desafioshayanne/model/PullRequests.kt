package com.shayanne.desafioshayanne.model

import com.google.gson.annotations.SerializedName

data class PullRequests(

    @SerializedName("title") val title: String,
    @SerializedName("body") val body: String,
    @SerializedName("user") val user: Owner,
    @SerializedName("html_url") val htmlUrl: String,
    @SerializedName("full_name") val fullName: String

)

