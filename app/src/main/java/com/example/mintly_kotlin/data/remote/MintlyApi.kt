package com.example.mintly_kotlin.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MintlyApi {

    @GET("api/cards")
    suspend fun readAllCards(
        @Query("q") query: String? = null
    ): Response<List<CardDto>>

    @GET("api/cards/{id}")
    suspend fun readCardById(
        @Path("id") id: Int
    ): Response<CardDto>
}
