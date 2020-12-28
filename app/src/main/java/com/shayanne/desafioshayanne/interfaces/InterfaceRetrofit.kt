package com.shayanne.desafioshayanne.interfaces

import android.content.ClipData
import com.shayanne.desafioshayanne.modelo.Items
import com.shayanne.desafioshayanne.modelo.ItensLista
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface InterfaceRetrofit {

    @GET("search/repositories?q=language:Java&sort=stars&page=1")
    fun getGit( ) :Call<Items>


}