package com.example.desafiogabriela.webservice


import com.example.desafiogabriela.model.Itens
import retrofit2.Call
import retrofit2.http.GET


interface WebClient {

    @GET("search/repositories?q=language:Java&sort=stars&page=1")
    fun busca(): Call<Itens>


}

