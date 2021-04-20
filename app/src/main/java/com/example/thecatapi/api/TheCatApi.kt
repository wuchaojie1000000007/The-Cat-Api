package com.example.thecatapi.api

import com.example.thecatapi.model.CatData
import retrofit2.Response
import retrofit2.http.GET

interface TheCatApi {

    @GET("/v1/images/search")
    suspend fun getCat(): Response<CatData>
}