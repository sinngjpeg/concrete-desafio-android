package com.sinngjpeg.github.services

import com.sinngjpeg.github.model.ItemRepository
import retrofit2.Call
import retrofit2.http.GET

interface RepositoryService {

  @GET("search/repositories?q=language:Java&sort=stars")
  fun getRepositories() : Call<ItemRepository>

}

//@GET("/search/repositories")
//fun getTopRepositories(
//    @Query("q") q: String,
//    @Query("sort") sort: String,
//    @Query("page") page: Int
//): Call<RepositoryModel>