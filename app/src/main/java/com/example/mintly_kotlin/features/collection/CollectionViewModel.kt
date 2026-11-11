package com.example.mintly_kotlin.features.collection

import androidx.lifecycle.ViewModel
import com.example.mintly_kotlin.data.Card
import com.example.mintly_kotlin.data.CardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class CollectionScreenState (
    val text: String = "",
    val cardList: List<Card> = emptyList(),
    val totalAmount: Double = 0.0
)

@HiltViewModel
class CollectionViewModel @Inject constructor(private val repository: CardRepository): ViewModel() {
    private val _state = MutableStateFlow(buildState(""))
    val state: StateFlow<CollectionScreenState>
        get() = _state.asStateFlow()

    private fun filterCards(text: String): List<Card> {
        return repository.getAll()
            .filter { card -> card.name.contains(text, ignoreCase = true) }
            .sortedByDescending { it.price }
    }

    private fun buildState(text: String): CollectionScreenState {
        val cards = filterCards(text)
        return CollectionScreenState(
            text = text,
            cardList = cards,
            totalAmount = cards.sumOf { it.price }
        )
    }

    fun changeText(newText: String) {
        _state.value = buildState(newText)
    }
}