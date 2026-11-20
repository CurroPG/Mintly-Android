package com.example.mintly_kotlin.features.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mintly_kotlin.data.CartItem
import com.example.mintly_kotlin.data.CartRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

data class CartScreenState(
    val cartList: List<CartItem> = emptyList(),
    val subtotal: Double = 0.0,
    val shipping: Double = 3.90,
    val total: Double = 0.0
)

@HiltViewModel
class CartViewModel @Inject constructor(
    private val repository: CartRepository
) : ViewModel() {
    val state: StateFlow<CartScreenState> =
        repository.observeCart().map { buildState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = buildState(emptyList())
            )

    fun increaseQuantity(item: CartItem) {
       viewModelScope.launch { repository.updateQuantity(item.product.id, item.quantity + 1 ) }
    }

    fun decreaseQuantity(item: CartItem) {
        if (item.quantity > 1) {
            viewModelScope.launch { repository.updateQuantity(item.product.id, item.quantity - 1 ) }
        }
    }

    fun removeItem(item: CartItem) {
        viewModelScope.launch { repository.removeProduct(item.product.id) }
    }

    private fun buildState(items: List<CartItem>): CartScreenState {
        val subtotal = items.sumOf { it.product.price * it.quantity }
        val shipping = if (items.isEmpty()) 0.0 else 3.90
        return CartScreenState(
            cartList = items,
            subtotal = subtotal,
            shipping = shipping,
            total = subtotal + shipping
        )
    }
}