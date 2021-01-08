package com.shayanne.desafioshayanne.interfaces

import com.shayanne.desafioshayanne.modelo.ItemsRepositories
import com.shayanne.desafioshayanne.modelo.PullRequests
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WebClientResquestPull {

    @GET("search/repositories?q=language:Java&sort=stars&")
    fun getRepositories(@Query("page")page:Int) :Call<ItemsRepositories>

 /*   @GET("search/repositories?q=language:Java&sort=stars&page=1")
    fun getPullRequests( ) :Call<ItemsPullRequests>*/

    @GET("repos/{owner}/{repositorio}/pulls")
    fun getPullRequests(@Path("owner") donoRep: String, @Path("repositorio") nome_repositorio: String): Call<List<PullRequests>>



}