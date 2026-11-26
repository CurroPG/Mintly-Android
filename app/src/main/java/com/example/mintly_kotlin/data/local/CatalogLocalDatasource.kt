package com.example.mintly_kotlin.data.local

import kotlinx.coroutines.flow.Flow

interface CatalogLocalDatasource {

    fun observeAll(): Flow<List<CardEntity>>

    suspend fun insertAll(cards: List<CardEntity>)
}