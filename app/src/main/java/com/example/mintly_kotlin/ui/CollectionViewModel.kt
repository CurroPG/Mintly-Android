package com.example.mintly_kotlin.ui

import androidx.lifecycle.ViewModel
import com.example.mintly_kotlin.data.Card
import com.example.mintly_kotlin.data.CardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CollectionViewModel @Inject constructor(
    private val repository: CardRepository
): ViewModel() {
    val cards: List<Card> = repository.getAll()
}