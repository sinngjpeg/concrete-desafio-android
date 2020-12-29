package com.sinngjpeg.github.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {

    val baseUrl = "https://api.github.com/"

    fun initRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    val service  = initRetrofit().create(RepositoryService::class.java)
}


