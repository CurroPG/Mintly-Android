package com.example.mintly_kotlin.core.ui.components

import java.text.NumberFormat
import java.util.Currency
import java.util.Locale

fun Double.toEuros(): String {
    val format = NumberFormat.getCurrencyInstance(Locale.getDefault())
    format.currency = Currency.getInstance("EUR")
    return format.format(this)
}