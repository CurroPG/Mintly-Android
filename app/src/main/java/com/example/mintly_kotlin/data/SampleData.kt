package com.example.mintly_kotlin.data

import com.example.mintly_kotlin.R

object SampleData {

    val homeOffers = listOf(
        Product(1, "Limited pack", "Obsidian Flames", 42.90, image = R.drawable.charizard),
        Product(2, "Tin box", "Pokémon 151", 24.50, image = R.drawable.pikachu),
        Product(3, "Gardevoir ex card", "Paldean Fates", 18.90, image = R.drawable.pikachu),
        Product(4, "24-pack box", "Evolving Skies", 36.00, image = R.drawable.charizard)
    )

    val shopOffers = listOf(
        Product(5, "10-card pack", "Scarlet & Violet", 4.99, oldPrice = 5.99, image = R.drawable.charizard),
        Product(6, "Elite Trainer Box", "Pokémon 151", 59.90, image = R.drawable.pikachu),
        Product(7, "3-pack blister", "Evolving Skies", 16.50, oldPrice = 18.90, image = R.drawable.pikachu),
        Product(8, "36-pack box", "Obsidian Flames", 149.00, image = R.drawable.charizard),
        Product(9, "Mintly sleeves x60", "Accessories", 7.90, image = R.drawable.pikachu),
        Product(10, "9-pocket binder", "Accessories", 19.90, oldPrice = 24.90, image = R.drawable.charizard)
    )

    val cartItems = listOf(
        CartItem(Product(11, "Charizard ex", "Obsidian Flames", 42.90, image = R.drawable.charizard), 1),
        CartItem(Product(12, "Mew ex", "Pokémon 151", 24.50, image = R.drawable.pikachu), 1),
        CartItem(Product(13, "Gardevoir ex", "Paldean Fates", 18.90, image = R.drawable.pikachu), 1)
    )
}