package com.example.mintly_kotlin.data.local

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CartRoomDatasource @Inject constructor(
    private val cartDao: CartDao
) : CartLocalDatasource {

    override fun observeAll(): Flow<List<CartItemEntity>> {
        return cartDao.observeAll()
    }

    override suspend fun getById(id: Int): CartItemEntity? {
        return cartDao.getById(id)
    }

    override suspend fun insert(item: CartItemEntity) {
        cartDao.insert(item)
    }

    override suspend fun deleteById(id: Int) {
        cartDao.deleteById(id)
    }

    override suspend fun deleteAll() {
        cartDao.deleteAll()
    }
}