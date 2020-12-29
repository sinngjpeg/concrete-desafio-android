package com.example.desafiogabriela.webservice

import com.example.desafiogabriela.ItemMain
import com.example.desafiogabriela.model.Itens
import retrofit2.Call
import retrofit2.http.GET


interface WebClient {

    @GET("search/repositories?q=language:Java&sort=stars")
    fun busca(): Call<Itens>
}

