package com.example.mintly_kotlin.data.local

import com.example.mintly_kotlin.data.CartItem
import com.example.mintly_kotlin.data.Product
import kotlinx.coroutines.flow.Flow

interface CartLocalDatasource {

    fun observeAll(): Flow<List<CartItemEntity>>
    suspend fun getById(id: Int): CartItemEntity?
    suspend fun insert(item: CartItemEntity)
    suspend fun deleteById(id: Int)
    suspend fun deleteAll()

}