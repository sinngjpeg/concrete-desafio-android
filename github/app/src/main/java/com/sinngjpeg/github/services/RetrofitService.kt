package com.sinngjpeg.github.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    val baseUrl = "https://api.github.com/"
    fun initRepositories(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val service = initRepositories().create(GitHubService::class.java)
}