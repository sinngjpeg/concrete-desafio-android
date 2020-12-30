package com.shayanne.desafioshayanne.webservices

import com.shayanne.desafioshayanne.interfaces.WebClientResquestPull
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object InicializadorRepositories {

    fun initRep (): WebClientResquestPull{

        return  Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WebClientResquestPull::class.java)


    }



   // val service: RepositorioService = retrofit.create<RepositorioService>(RepositorioService::class.java)
}