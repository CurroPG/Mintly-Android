package com.example.mintly_kotlin.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun HomeScreen(
    toCardCollection: () -> Unit,
    toShop: () -> Unit,
    toRegister: () -> Unit,
    toGame: () -> Unit
){
    LazyColumn()  {
        item {
            Button(onClick = { toCardCollection() }) {
                Text("My Collection")
            }
        }
        item {
            Button(onClick = { toShop() }) {
                Text("Shop")
            }
        }
        item {
            Button(onClick = { toRegister() }) {
                Text("Register")
            }
        }
        item {
            Button(onClick = { toGame() }) {
                Text("Play")
            }
        }
    }
}