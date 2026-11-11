package com.example.mintly_kotlin.features.collection

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.mintly_kotlin.R
import com.example.mintly_kotlin.core.ui.components.CardItem
import com.example.mintly_kotlin.core.ui.components.MintlyTopBar
import com.example.mintly_kotlin.core.ui.components.SearchField
import com.example.mintly_kotlin.core.ui.components.toEuros

@Composable
fun CollectionScreen(
    toHome: () -> Unit,
    viewModel: CollectionViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            MintlyTopBar(
                title = stringResource(R.string.my_collection),
                onBack = toHome,
                actions = {
                    FilledTonalIconButton(onClick = {}) {
                        Icon(Icons.Default.Tune, contentDescription = stringResource(R.string.filters))
                    }
                }
            )
        }
    ) { innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(horizontal = 20.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item(span = { GridItemSpan(maxLineSpan) }) {
                Column {
                    Text(
                        stringResource(R.string.total_value),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        state.totalAmount.toEuros(),
                        style = MaterialTheme.typography.headlineLarge,
                        color = MaterialTheme.colorScheme.primary,
                    )
                }
            }
            item(span = { GridItemSpan(maxLineSpan) }) {
                SearchField(
                    value = state.text,
                    onValueChange = viewModel::changeText,
                    placeholder = stringResource(R.string.search_collection)
                )
            }
            item(span = { GridItemSpan(maxLineSpan) }) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        stringResource(R.string.cards_count, state.cardList.size),
                        style = MaterialTheme.typography.labelLarge
                    )
                    Text(
                        stringResource(R.string.sort_value_desc),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
            items(state.cardList, key = { it.id }) { card ->
                CardItem(card = card, onClick = {})
            }
        }
    }
}