package com.sinngjpeg.github.services

import com.sinngjpeg.github.model.PullRequest
import com.sinngjpeg.github.model.Repository
import com.sinngjpeg.github.model.RepositoryModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RepositoryService : Call<RepositoryModel> {

  @GET("search/repositories?q=language:Java&sort=stars&")
  fun getRepositories(
      /////////////////
  ) : Call<RepositoryModel>

}

//@GET("/search/repositories")
//fun getTopRepositories(
//    @Query("q") q: String,
//    @Query("sort") sort: String,
//    @Query("page") page: Int
//): Call<RepositoryModel>