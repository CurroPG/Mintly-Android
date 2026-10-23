package com.example.mintly_kotlin.data

interface CardRepository{
    fun getAll(): List<Card>
    fun getOne(id: Int): Card?
    fun orderByName(): List<Card>
    fun orderByPrice(): List<Card>
    fun orderByType(): List<Card>
    fun orderByRecent(): List<Card>
}