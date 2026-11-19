package com.example.mintly_kotlin.data

import kotlinx.coroutines.flow.Flow

interface CartRepository {
    fun observeCart(): Flow<List<CartItem>>

    suspend fun addProduct(product: Product)

    suspend fun updateQuantity(productId: Int, quantity: Int)

    suspend fun removeProduct(productId: Int)

    suspend fun clear()
}
