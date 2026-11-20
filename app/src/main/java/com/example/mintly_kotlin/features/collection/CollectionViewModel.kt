package com.example.mintly_kotlin.features.collection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mintly_kotlin.data.Card
import com.example.mintly_kotlin.data.CatalogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

data class CollectionScreenState (
    val text: String = "",
    val cardList: List<Card> = emptyList(),
    val totalAmount: Double = 0.0,
    val isLoading: Boolean = false,
    val isOffline: Boolean = false
)

@HiltViewModel
class CollectionViewModel @Inject constructor(private val repository: CatalogRepository): ViewModel() {
    private val _state = MutableStateFlow(CollectionScreenState())
    val state: StateFlow<CollectionScreenState>
        get() = _state.asStateFlow()

    private var allCards: List<Card> = emptyList()

    init {
        viewModelScope.launch {
            repository.observeCards().collect { cards ->
                allCards = cards
                _state.value = buildState(_state.value.text)
            }
        }
        refresh()
    }

    fun refresh() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true, isOffline = false)
            try {
                repository.refresh()
            } catch (e: IOException) {
                _state.value = _state.value.copy(isOffline = true)
            } finally {
                _state.value = _state.value.copy(isLoading = false)
            }
        }
    }

    private fun filterCards(text: String): List<Card> {
        return allCards
            .filter { card -> card.name.contains(text, ignoreCase = true) }
            .sortedByDescending { it.price }
    }

    private fun buildState(text: String): CollectionScreenState {
        val cards = filterCards(text)
        return _state.value.copy(
            text = text,
            cardList = cards,
            totalAmount = cards.sumOf { it.price }
        )
    }

    fun changeText(newText: String) {
        _state.value = buildState(newText)
    }
}