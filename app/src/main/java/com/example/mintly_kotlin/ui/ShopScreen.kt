package com.example.mintly_kotlin.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ShopScreen(
    toHome: () -> Unit
){
    Column {
        Text("SHOP")
        Button(onClick = toHome) {
            Text("Return Home")
        }
    }
}