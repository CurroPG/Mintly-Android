package com.example.mintly_kotlin.data

import com.example.mintly_kotlin.data.local.CatalogLocalDatasource
import com.example.mintly_kotlin.data.local.toModel
import com.example.mintly_kotlin.data.remote.CatalogRemoteDatasource
import com.example.mintly_kotlin.data.remote.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CatalogRepositoryImpl @Inject constructor(
    private val remote: CatalogRemoteDatasource,
    private val local: CatalogLocalDatasource
) : CatalogRepository {

    override fun observeCards(): Flow<List<Card>> {
        return local.observeAll().map { entities ->
            entities.map { it.toModel() }
        }
    }

    override suspend fun refresh() {
        val cards = remote.readAllCards()
        local.insertAll(cards.map { it.toEntity() })
    }
}