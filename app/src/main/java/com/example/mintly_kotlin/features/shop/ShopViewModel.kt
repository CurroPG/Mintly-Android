package com.example.mintly_kotlin.features.shop

import androidx.lifecycle.ViewModel
import com.example.mintly_kotlin.R
import com.example.mintly_kotlin.data.Product
import com.example.mintly_kotlin.data.SampleData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class ShopScreenState (
    val text: String = "",
    val filterChosen: Int = R.string.filter_all,
    val productList: List<Product> = emptyList()
)

@HiltViewModel
class ShopViewModel @Inject constructor(): ViewModel() {
    private val _state = MutableStateFlow(ShopScreenState(productList = SampleData.shopOffers))
    val state: StateFlow<ShopScreenState>
        get() = _state.asStateFlow()

    fun changeText(newText: String) {
        val oldState = state.value
        _state.value = oldState.copy(
            text = newText,
            productList = filterProducts(newText, oldState.filterChosen)
        )
    }

    fun changeFilter(newFilter: Int) {
        val oldState = state.value
        _state.value = oldState.copy(
            filterChosen = newFilter,
            productList = filterProducts(oldState.text, newFilter)
        )
    }

    private fun filterProducts(text: String, filter: Int): List<Product> {
        return SampleData.shopOffers.filter { product ->
            val matchesText = product.name.contains(text, ignoreCase = true)
            val matchesFilter = filter == R.string.filter_all || product.category == filter
            matchesText && matchesFilter
        }
    }
}