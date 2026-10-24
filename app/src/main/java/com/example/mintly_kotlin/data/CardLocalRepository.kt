package com.example.mintly_kotlin.data

import com.example.mintly_kotlin.R
import javax.inject.Inject

class CardLocalRepository @Inject constructor(): CardRepository {

    private val CardList = listOf<Card> (
        Card(id= 1, name = "Pikachu ex 057/191", price = 28.66, image = R.drawable.pikachu, type = "Electric", uploadDate = "24-10-2026"),
        Card(id= 2, name = "Charizard V 017/172", price = 37.22, image = R.drawable.charizard, type = "Fire", uploadDate = "24-10-2026")
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