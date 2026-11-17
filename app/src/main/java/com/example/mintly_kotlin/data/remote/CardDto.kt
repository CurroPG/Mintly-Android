package com.example.mintly_kotlin.data.remote

import com.example.mintly_kotlin.data.local.CardEntity
import kotlin.String

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

fun CardDto.toEntity(): CardEntity{
    return CardEntity(
        id = this.id,
        externalId = this.externalId,
        name = this.name,
        setName = this.setName,
        number = this.number,
        rarity = this.rarity,
        imageUrl = this.imageUrl,
        marketPrice = this.marketPrice,
        priceUpdatedAt = this.priceUpdatedAt
    )
}