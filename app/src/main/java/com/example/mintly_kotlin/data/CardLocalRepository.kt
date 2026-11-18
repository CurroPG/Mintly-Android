package com.example.mintly_kotlin.data

import javax.inject.Inject

class CardLocalRepository @Inject constructor(): CardRepository {

    private val CardList = listOf<Card>(
        Card(id = 1, name = "Charizard ex", price = 245.00, imageUrl = "https://assets.tcgdex.net/en/swsh/swsh3/19/high.png", type = "Fire", uploadDate = "24-10-2026", level = 76, rarity = "Rara", hp = 330, attack = 180),
        Card(id = 2, name = "Umbreon V", price = 198.50, imageUrl = "https://assets.tcgdex.net/en/swsh/swsh3/10/high.png", type = "Dark", uploadDate = "24-10-2026", level = 64, rarity = "Rara", hp = 200, attack = 160),
        Card(id = 3, name = "Mewtwo V", price = 124.90, imageUrl = "https://assets.tcgdex.net/en/swsh/swsh3/123/high.png", type = "Psychic", uploadDate = "24-10-2026", level = 70, rarity = "Rara", hp = 220, attack = 190),
        Card(id = 4, name = "Rayquaza VMAX", price = 112.00, imageUrl = "https://assets.tcgdex.net/en/swsh/swsh3/57/high.png", type = "Dragon", uploadDate = "24-10-2026", level = 82, rarity = "Ultra rara", hp = 320, attack = 210),
        Card(id = 5, name = "Gardevoir ex", price = 89.90, imageUrl = "https://assets.tcgdex.net/en/swsh/swsh3/54/high.png", type = "Psychic", uploadDate = "24-10-2026", level = 58, rarity = "Rara", hp = 310, attack = 150),
        Card(id = 6, name = "Mew ex", price = 76.50, imageUrl = null, type = "Psychic", uploadDate = "24-10-2026", level = 62, rarity = "Rara", hp = 180, attack = 140)
    )

    override fun getAll(): List<Card> {
        return CardList
    }

    override fun getOne(id: Int): Card? {
        return CardList.find { it.id == id }
    }

    override fun orderByName(): List<Card> {
        return CardList.sortedBy { it.name }
    }

    override fun orderByPrice(): List<Card> {
        return CardList.sortedBy { it.price }
    }

    override fun orderByType(): List<Card> {
        return CardList.sortedBy { it.type }
    }

    override fun orderByRecent(): List<Card> {
        return CardList.sortedBy { it.uploadDate }
    }

}