package com.example.mintly_kotlin.data

import com.example.mintly_kotlin.data.local.CartDao
import com.example.mintly_kotlin.data.local.toEntity
import com.example.mintly_kotlin.data.local.toModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CartLocalRepository @Inject constructor(
    private val cartDao: CartDao
) : CartRepository {

    override fun observeCart(): Flow<List<CartItem>> {
        return cartDao.observeAll().map { entities ->
            entities.map { it.toModel() }
        }
    }

    override suspend fun addProduct(product: Product) {
        val current = cartDao.getById(product.id)
        val quantity = (current?.quantity ?: 0) + 1
        cartDao.insert(CartItem(product, quantity).toEntity())
    }

    override suspend fun updateQuantity(productId: Int, quantity: Int) {
        if (quantity <= 0) {
            cartDao.deleteById(productId)
            return
        }
        val current = cartDao.getById(productId) ?: return
        cartDao.insert(current.copy(quantity = quantity))
    }

    override suspend fun removeProduct(productId: Int) {
        cartDao.deleteById(productId)
    }

    override suspend fun clear() {
        cartDao.deleteAll()
    }
}
