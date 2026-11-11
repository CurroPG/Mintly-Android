package com.example.mintly_kotlin.features.cart

import androidx.lifecycle.ViewModel
import com.example.mintly_kotlin.data.CartItem
import com.example.mintly_kotlin.data.SampleData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class CartScreenState(
    val cartList: List<CartItem> = emptyList(),
    val subtotal: Double = 0.0,
    val shipping: Double = 3.90,
    val total: Double = 0.0
)

@HiltViewModel
class CartViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(buildState(SampleData.cartItems))
    val state: StateFlow<CartScreenState>
        get() = _state.asStateFlow()

    fun increaseQuantity(item: CartItem) {
        val newItems = state.value.cartList.map {
            if (it.product.id == item.product.id) it.copy(quantity = it.quantity + 1) else it
        }
        _state.value = buildState(newItems)
    }

    fun decreaseQuantity(item: CartItem) {
        val newItems = state.value.cartList.map {
            if (it.product.id == item.product.id && it.quantity > 1) it.copy(quantity = it.quantity - 1) else it
        }
        _state.value = buildState(newItems)
    }

    fun removeItem(item: CartItem) {
        val newItems = state.value.cartList.filter { it.product.id != item.product.id }
        _state.value = buildState(newItems)
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