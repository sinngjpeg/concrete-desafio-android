package com.sinngjpeg.github.webservices

import com.sinngjpeg.github.model.data.ItemRepository
import com.sinngjpeg.github.model.data.PullRequest
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubInterface {

    @GET("search/repositories?q=language:Java&sort=stars")
    fun getRepositories(@Query("page")page: Int): Call<ItemRepository>

    @GET("repos/{owner}/{repo}/pulls")
    fun getPullRequests(
        @Path("owner") creator: String,
        @Path("repo") repository: String
    ): Call<List<PullRequest>>
}

