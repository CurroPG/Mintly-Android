package com.example.mintly_kotlin.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cards")
data class CardEntity (
    @PrimaryKey
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