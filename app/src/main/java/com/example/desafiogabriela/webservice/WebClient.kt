package com.example.desafiogabriela.webservice


import com.example.desafiogabriela.model.ItemPullrequest
import com.example.desafiogabriela.model.Items
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface WebClient {

    @GET("search/repositories?q=language:Java&sort=stars")
    fun busca(@Query("page")page: Int): Call<Items>

    @GET("repos/{owner}/{repositorio}/pulls")
    fun buscaPull(@Path("owner") owner: String, @Path("repositorio") repositorio: String): Call<List<ItemPullrequest>>


}

