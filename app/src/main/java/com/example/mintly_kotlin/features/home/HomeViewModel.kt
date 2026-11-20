package com.example.mintly_kotlin.features.home

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

data class HomeScreenState (
    val cardList: List<Card> = emptyList(),
    val isLoading: Boolean = false,
    val isOffline: Boolean = false
)

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: CatalogRepository) : ViewModel() {
    private val _state = MutableStateFlow(HomeScreenState())
    val state: StateFlow<HomeScreenState>
        get() = _state.asStateFlow()

    init {
        viewModelScope.launch {
            repository.observeCards().collect { cards ->
                _state.value = _state.value.copy(cardList = cards)
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
}