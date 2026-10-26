package com.example.mintly_kotlin.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel

@Composable
fun CollectionScreen(
    toHome: () -> Unit,
    viewModel: CollectionViewModel = hiltViewModel()
){
    Column {
        Text("Tienes ${viewModel.cards.size} cartas")
        Button(onClick = toHome) {
            Text("Volver al inicio")
        }
    }
}