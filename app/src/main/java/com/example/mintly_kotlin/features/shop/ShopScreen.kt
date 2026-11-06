package com.example.mintly_kotlin.features.shop
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mintly_kotlin.R
import com.example.mintly_kotlin.core.ui.components.CartBadgeIcon
import com.example.mintly_kotlin.core.ui.components.MintlyBottomBar
import com.example.mintly_kotlin.core.ui.components.MintlyTopBar
import com.example.mintly_kotlin.core.ui.components.ProductCard
import com.example.mintly_kotlin.core.ui.components.SearchField
import com.example.mintly_kotlin.data.SampleData
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme

@Composable
fun ShopScreen(
    toHome: () -> Unit,
    toCart: () -> Unit,
    toGame: () -> Unit
){
    var search by remember { mutableStateOf("") }
    var selectedFilter by remember { mutableIntStateOf(R.string.filter_all) }
    val filters = listOf(
        R.string.filter_all,
        R.string.filter_packs,
        R.string.filter_boxes,
        R.string.filter_single_cards,
        R.string.filter_accessories
    )

    Scaffold(
        topBar = {
            MintlyTopBar(
                title = stringResource(R.string.shop),
                onBack = toHome,
                actions = {
                    CartBadgeIcon(count = SampleData.cartItems.size, onClick = toCart)
                }
            )
        },
        bottomBar = {
            MintlyBottomBar(
                cartCount = SampleData.cartItems.size,
                onCartClick = toCart,
                onPlayClick = toGame,
                onCameraClick = {}
            )
        }
    ) { innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.padding(innerPadding),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item(span = { GridItemSpan(maxLineSpan) }) {
                SearchField(
                    value = search,
                    onValueChange = { search = it },
                    placeholder = stringResource(R.string.search_shop)
                )
            }
            item(span = { GridItemSpan(maxLineSpan) }) {
                LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(filters) { filterRes ->
                        FilterChip(
                            selected = selectedFilter == filterRes,
                            onClick = { selectedFilter = filterRes },
                            label = { Text(stringResource(filterRes)) }
                        )
                    }
                }
            }
            item(span = { GridItemSpan(maxLineSpan) }) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.shapes.large,
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.inverseSurface
                    )
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Text(
                            text = stringResource(R.string.new_expansion),
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.primaryContainer
                        )
                        Text(
                            text = stringResource(R.string.banner_title),
                            style = MaterialTheme.typography.headlineMedium,
                            color = MaterialTheme.colorScheme.inverseOnSurface
                        )
                        Text(
                            text = stringResource(R.string.banner_subtitle),
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.inverseOnSurface
                        )
                        Button(
                            onClick = {},
                            modifier = Modifier.padding(top = 16.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        ) {
                            Text(stringResource(R.string.see_products))
                        }
                    }
                }
            }
            item(span = { GridItemSpan(maxLineSpan) }) {
                Text(
                    text = stringResource(R.string.weekly_offers),
                    style = MaterialTheme.typography.titleLarge
                )
            }
            items(SampleData.shopOffers) { product ->
                ProductCard(product = product, onClick = {})
            }
        }
    }
}