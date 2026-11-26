package com.example.mintly_kotlin.data

import com.example.mintly_kotlin.data.local.CartLocalDatasource
import com.example.mintly_kotlin.data.local.toEntity
import com.example.mintly_kotlin.data.local.toModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CartLocalRepository @Inject constructor(
    private val local: CartLocalDatasource
) : CartRepository {

    override fun observeCart(): Flow<List<CartItem>> {
        return local.observeAll().map { entities ->
            entities.map { it.toModel() }
        }
    }

    override suspend fun addProduct(product: Product) {
        val current = local.getById(product.id)
        val quantity = (current?.quantity ?: 0) + 1
        local.insert(CartItem(product, quantity).toEntity())
    }

    override suspend fun updateQuantity(productId: Int, quantity: Int) {
        if (quantity <= 0) {
            local.deleteById(productId)
            return
        }
        val current = local.getById(productId) ?: return
        local.insert(current.copy(quantity = quantity))
    }

    override suspend fun removeProduct(productId: Int) {
        local.deleteById(productId)
    }

    override suspend fun clear() {
        local.deleteAll()
    }
}