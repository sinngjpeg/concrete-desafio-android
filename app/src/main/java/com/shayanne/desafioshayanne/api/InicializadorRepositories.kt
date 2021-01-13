package com.shayanne.desafioshayanne.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object InicializadorRepositories {

    /*  fun initRep ():   WebClientResquestPull{

          return  Retrofit.Builder()
                  .baseUrl("https://api.github.com/")
                  .addConverterFactory(GsonConverterFactory.create())
                  .build()
                  .create(WebClientResquestPull::class.java)

      }*/

    val webClientGithub = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(WebClientResquestPull::class.java)

}