package com.shayanne.desafioshayanne.webservices

import com.shayanne.desafioshayanne.interfaces.WebClientResquestPull
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object InicializadorPullRequests {

    fun initPull (): WebClientResquestPull {

        return  Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WebClientResquestPull::class.java)


    }
}