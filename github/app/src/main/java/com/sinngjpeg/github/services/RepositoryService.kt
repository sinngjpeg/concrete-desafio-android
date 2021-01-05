package com.sinngjpeg.github.services

import com.sinngjpeg.github.model.ItemRepository
import com.sinngjpeg.github.model.PullRequest
import com.sinngjpeg.github.model.Repository
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RepositoryService {

    @GET("search/repositories?q=language:Java&sort=stars")
    fun getRepositories(@Query("page")page: Int): Call<ItemRepository>

}

