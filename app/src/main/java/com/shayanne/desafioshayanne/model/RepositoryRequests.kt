package com.shayanne.desafioshayanne.model

import com.google.gson.annotations.SerializedName

data class RepositoryRequests(
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("owner") val owner: Owner,
    @SerializedName("full_name") val fullName: String,
    @SerializedName("forks_count") var forksCount: Int,
    @SerializedName("stargazers_count") var stargazersCount: Int
)
