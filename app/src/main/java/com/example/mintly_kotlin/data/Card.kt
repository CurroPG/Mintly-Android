package com.example.mintly_kotlin.data

data class Card (
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