package com.example.mintly_kotlin.data.remote

import java.io.IOException
import javax.inject.Inject

class CatalogRetrofitDatasource @Inject constructor(
    private val api: MintlyApi
): CatalogRemoteDatasource {

    override suspend fun readAllCards(): List<CardDto> {
        val response = api.readAllCards()

        if (!response.isSuccessful) {
            throw IOException("El backend respondió ${response.code()} al pedir las cartas")
        }

        val cards = response.body() ?: emptyList()
        return cards
    }
}