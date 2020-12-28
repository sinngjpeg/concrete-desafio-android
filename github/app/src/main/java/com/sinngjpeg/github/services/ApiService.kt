package com.sinngjpeg.github.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {

    val baseUrl = "https://api.github.com/"

    fun initRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    val service  = initRetrofit().create(RepositoryService::class.java)
}


//class ApiService private constructor() {
//
//    companion object {
//
//        private lateinit var retrofit: Retrofit
//        private val baseUrl = "https://api.github.com/"
//
//        fun initRetrofit(): Retrofit {
//            val httpClient = OkHttpClient.Builder()
//            if (!::retrofit.isInitialized) {
//                retrofit = Retrofit.Builder()
//                    .baseUrl(baseUrl)
//                    .client(httpClient.build())
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build()
//                    .create()
//            }
//            return retrofit
//        }
//
//        fun <S> createService(serviceClass: Class<S>): S {
//            return initRetrofit().create(serviceClass)
//        }
//
//    }
//}


