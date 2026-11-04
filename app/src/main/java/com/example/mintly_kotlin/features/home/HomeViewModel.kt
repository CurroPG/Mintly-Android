package com.example.mintly_kotlin.features.home

import androidx.lifecycle.ViewModel
import com.example.mintly_kotlin.data.Card
import com.example.mintly_kotlin.data.CardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    repository: CardRepository
) : ViewModel() {
    val featuredCards: List<Card> = repository.getAll()
}