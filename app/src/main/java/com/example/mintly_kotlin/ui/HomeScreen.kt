package com.example.mintly_kotlin.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import com.example.mintly_kotlin.core.navigation.Route

@Composable
fun HomeScreen(
    toCardCollection: () -> Unit,
    toShop: () -> Unit,
    toRegister: () -> Unit,
    toGame: () -> Unit
){
    LazyColumn()  {

    }
}