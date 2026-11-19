package com.example.mintly_kotlin.data

import com.example.mintly_kotlin.data.local.CardDao
import com.example.mintly_kotlin.data.local.toModel
import com.example.mintly_kotlin.data.remote.MintlyApi
import com.example.mintly_kotlin.data.remote.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

class CatalogRepositoryImpl @Inject constructor(
    private val api: MintlyApi,
    private val cardDao: CardDao
) : CatalogRepository {

    override fun observeCards(): Flow<List<Card>> {
        return cardDao.observeAll().map { entities ->
            entities.map { it.toModel() }
        }
    }

    override suspend fun refresh() {
        val response = api.readAllCards()

        if (!response.isSuccessful) {
            throw IOException("El backend respondió ${response.code()} al pedir las cartas")
        }

        val cards = response.body() ?: emptyList()
        cardDao.insertAll(cards.map { it.toEntity() })
    }
}
