package com.example.mintly_kotlin.data

import kotlinx.coroutines.flow.Flow

interface CatalogRepository {
    fun observeCards(): Flow<List<Card>>

    suspend fun refresh()
}
