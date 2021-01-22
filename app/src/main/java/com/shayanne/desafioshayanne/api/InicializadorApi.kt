package com.shayanne.desafioshayanne.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object InicializadorApi {

    val webClientGithub = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiWebClientRequest::class.java)
}
