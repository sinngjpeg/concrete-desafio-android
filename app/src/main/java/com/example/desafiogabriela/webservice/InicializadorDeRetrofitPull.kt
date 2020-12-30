package com.example.desafiogabriela.webservice

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object InicializadorDeRetrofitPull{
    fun  getPull(): WebClientPull {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WebClientPull::class.java)
    }
}