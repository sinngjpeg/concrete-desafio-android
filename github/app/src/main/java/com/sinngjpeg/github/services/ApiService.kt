package com.sinngjpeg.github.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {

    val baseUrl = "https://api.github.com/"

    fun initRepository(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val serviceRepository = initRepository().create(RepositoryService::class.java)


    fun initPullRequest(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiService.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val servicePullRequest = initPullRequest().create(PullRequestService::class.java)

}