package com.example.thecatapi.api

import com.example.thecatapi.util.Constants.Companion.BASEURL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val theCatApi by lazy { retrofit.create(TheCatApi::class.java) }
}