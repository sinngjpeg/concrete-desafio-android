package com.example.desafiogabriela.api

import com.example.desafiogabriela.model.ItemPullrequest
import com.example.desafiogabriela.model.Items
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubAPIService {

    @GET("search/repositories?q=language:Java&sort=stars")
    suspend fun search(@Query("page") page: Int): Items

    @GET("repos/{owner}/{repository}/pulls")
    fun searchPull(
        @Path("owner") owner: String,
        @Path("repository") repository: String,
    ): List<ItemPullrequest>
}
