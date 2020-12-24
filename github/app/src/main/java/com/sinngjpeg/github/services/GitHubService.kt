package com.sinngjpeg.github.services

import com.sinngjpeg.github.model.PullRequest
import com.sinngjpeg.github.model.Repository
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubService {


    @GET("/search/repositories")
    fun getRepositories(
        @Query("q") q: String,
        @Query("sort") sort: String,
        @Query("page") page: Int
    ): Call<Repository>

    @GET("repos/{creator}/{repository}/pulls")
    fun getPulls(
        @Path("creator") creator: String,
        @Path("repository") repositorie: String
    ): Call<List<PullRequest>>

}