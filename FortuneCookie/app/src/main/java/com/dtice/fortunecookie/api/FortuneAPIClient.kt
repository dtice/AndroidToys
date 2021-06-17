package com.dtice.fortunecookie.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object FortuneAPIClient {
    private const val baseUrl = "https://api.justyy.workers.dev/api/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()



    val apiService : FortuneAPI by lazy {
        retrofit.create(FortuneAPI::class.java)
    }
}