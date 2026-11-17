package com.example.mintly_kotlin.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mintly_kotlin.data.Card

@Entity(tableName = "cards")
data class CardEntity (
    @PrimaryKey
    val id: Int,
    val name: String,
    val price: Double,
    val image: Int,
    val type: String,
    val uploadDate: String,
    val level: Int = 0,
    val rarity: String = "",
    val hp: Int = 0,
    val attack: Int = 0
)

fun CardEntity.toModel(): Card {
    return Card(
        id = id,
        name = name,
        price = price,
        image = image,
        type = type,
        uploadDate = uploadDate,
        level = level,
        rarity = rarity,
        hp = hp,
        attack = attack
    )
}

fun Card.toEntity(): CardEntity {
    return CardEntity(
        id = id,
        name = name,
        price = price,
        image = image,
        type = type,
        uploadDate = uploadDate,
        level = level,
        rarity = rarity,
        hp = hp,
        attack = attack
    )
}