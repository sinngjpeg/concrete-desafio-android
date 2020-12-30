package com.example.desafiogabriela.webservice

import com.example.desafiogabriela.model.ItemPullrequest
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface WebClientPull {

    @GET("repos/{owner}/{repositorio}/pulls")
    fun buscaPull(@Path("owner") owner: String, @Path("repositorio") repositorio: String): Call<List<ItemPullrequest>>
}