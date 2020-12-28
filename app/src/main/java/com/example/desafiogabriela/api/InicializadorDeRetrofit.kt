package com.example.desafiogabriela.api

import com.example.desafiogabriela.webservice.WebClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object InicializadorDeRetrofit {
    fun get(): WebClient {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WebClient::class.java)
    }
}
