package com.example.mintly_kotlin.data

data class Card (
    val id: Int,
    val name: String,
    val price: Double,
    val imageUrl: String? = null,
    val level: Int = 0,
    val rarity: String = "",
    val hp: Int = 0,
    val attack: Int = 0
)