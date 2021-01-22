package com.shayanne.desafioshayanne.api

import com.shayanne.desafioshayanne.model.ItemsRepositories
import com.shayanne.desafioshayanne.model.PullRequests
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiWebClientRequest {

    @GET("search/repositories?q=language:Java&sort=stars&")
    fun getRepositories(@Query("page") page: Int): Call<ItemsRepositories>

    @GET("repos/{owner}/{repositorio}/pulls")
    fun getPullRequests(
        @Path("owner") owner: String,
        @Path("repositorio") repositorio: String
    ): Call<List<PullRequests>>
}
