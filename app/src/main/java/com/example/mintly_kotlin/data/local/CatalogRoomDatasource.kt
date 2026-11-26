package com.example.mintly_kotlin.data.local

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CatalogRoomDatasource @Inject constructor(
    private val cardDao: CardDao
): CatalogLocalDatasource {

    override fun observeAll(): Flow<List<CardEntity>> {
        return cardDao.observeAll()
    }

    override suspend fun insertAll(cards: List<CardEntity>) {
        cardDao.insertAll(cards)
    }
}