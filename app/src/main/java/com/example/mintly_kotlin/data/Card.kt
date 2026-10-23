package com.example.mintly_kotlin.data

data class Card (
    val id: Int,
    val name: String,
    val price: Double,
    val image: Int,
    val type: String,
    val uploadDate: String
)