package com.example.apidog

import android.text.style.QuoteSpan
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiDogs {

    @GET("images")
  suspend fun getQuotes(): Response<DataDogs>


}