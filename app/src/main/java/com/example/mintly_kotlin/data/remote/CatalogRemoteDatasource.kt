package com.example.mintly_kotlin.data.remote

interface CatalogRemoteDatasource{

    suspend fun readAllCards(): List<CardDto>
}