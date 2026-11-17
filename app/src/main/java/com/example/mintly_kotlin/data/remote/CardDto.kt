package com.example.mintly_kotlin.data.remote

data class CardDto (
    val id: Int,
    val externalId: String,
    val name: String,
    val setName: String,
    val number: String,
    val rarity: String? = null,
    val imageUrl: String? = null,
    val marketPrice: Double? = null,
    val priceUpdatedAt: String? = null
)