package com.example.apidog

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    val url = "https://dog.ceo/api/breed/germanshepherd/"


    fun getInstance(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}