package com.shayanne.desafioshayanne.api

import androidx.annotation.VisibleForTesting
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object InicializadorApi {
    //buider:
    var okHttpClient = OkHttpClient.Builder().build()

    @VisibleForTesting
    var baseUrl = "https://api.github.com/"

    //for iniciar o webclient só quando necessitamos
    // o delegate by lazy faz com que o webClient nao seja inicializado, para podermos fazer os testes
    //o by lazy nos permite inicializar somente os onjetos que necessitamos
    val webClientGithub by lazy { Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiWebClientRequest::class.java)}
}
