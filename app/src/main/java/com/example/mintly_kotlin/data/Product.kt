package com.example.mintly_kotlin.data

import kotlin.math.roundToInt

data class Product(
    val id: Int,
    val name: String,
    val set: String,
    val price: Double,
    val oldPrice: Double? = null,
    val image: Int
) {
    val discount: Int?
        get() = oldPrice?.let { ((1 - price / it) * 100).roundToInt() }
}

data class CartItem(
    val product: Product,
    val quantity: Int
)