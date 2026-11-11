package com.example.mintly_kotlin.features.home

import androidx.lifecycle.ViewModel
import com.example.mintly_kotlin.data.Card
import com.example.mintly_kotlin.data.CardRepository
import com.example.mintly_kotlin.features.collection.CollectionScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class HomeScreenState (
    val cardList: List<Card> = emptyList()
)


@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: CardRepository) : ViewModel() {
    private val _state = MutableStateFlow(HomeScreenState(cardList = repository.getAll()))
    val state: StateFlow<HomeScreenState>
        get() = _state.asStateFlow()
}