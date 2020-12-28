package com.shayanne.desafioshayanne.webservices

import com.shayanne.desafioshayanne.interfaces.InterfaceRetrofit
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object InicializadorRetrofit {

    fun initRep (): InterfaceRetrofit{

        return  Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(InterfaceRetrofit::class.java)


    }



   // val service: RepositorioService = retrofit.create<RepositorioService>(RepositorioService::class.java)
}