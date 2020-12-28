package com.example.desafiogabriela.webservice

import com.example.desafiogabriela.ItemMain
import com.example.desafiogabriela.model.Itens
import retrofit2.*
import retrofit2.http.GET


interface WebClient {

    @GET("busca")
    fun busca(): Call<Itens>
}

