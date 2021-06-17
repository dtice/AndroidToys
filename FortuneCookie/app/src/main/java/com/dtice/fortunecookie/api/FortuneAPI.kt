package com.dtice.fortunecookie.api

import retrofit2.Call
import retrofit2.http.GET

interface FortuneAPI {
    @GET("fortune")
    fun fetchFortune(): Call<String?>
}