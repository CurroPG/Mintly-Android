package com.example.mintly_kotlin.features.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Bolt
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.Eco
import androidx.compose.material.icons.outlined.LocalFlorist
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Shield
import androidx.compose.material.icons.outlined.WaterDrop
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.mintly_kotlin.R
import com.example.mintly_kotlin.core.ui.components.CardItem
import com.example.mintly_kotlin.core.ui.components.MintlyBottomBar
import com.example.mintly_kotlin.core.ui.components.ProductPairRow
import com.example.mintly_kotlin.core.ui.components.SectionHeader
import com.example.mintly_kotlin.data.SampleData

@Composable
fun HomeScreen(
    toCardCollection: () -> Unit,
    toShop: () -> Unit,
    toCart: () -> Unit,
    toRegister: () -> Unit,
    toGame: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(start = 20.dp, end = 20.dp, top = 8.dp, bottom = 110.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {
                    HomeHeader(onSettingsClick = {}, onProfileClick = toRegister)
                }
                item {
                    SectionHeader(
                        title = stringResource(R.string.your_collection),
                        actionText = stringResource(R.string.see_all),
                        onAction = toCardCollection
                    )
                }
                item {
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        items(state.cardList, key = { it.id }) { card ->
                            CardItem(
                                card = card,
                                onClick = {},
                                modifier = Modifier.width(130.dp),
                                showStats = true
                            )
                        }
                    }
                }
                item {
                    CompetitiveCard(onBattleClick = toGame)
                }
                item {
                    SectionHeader(
                        title = stringResource(R.string.latest_offers),
                        actionText = stringResource(R.string.see_all),
                        onAction = toShop
                    )
                }
                items(SampleData.homeOffers.chunked(2)) { pair ->
                    ProductPairRow(products = pair, onProductClick = {})
                }
            }

            MintlyBottomBar(
                cartCount = SampleData.cartItems.size,
                onCartClick = toCart,
                onPlayClick = toGame,
                onCameraClick = {},
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
    }
}

@Composable
private fun HomeHeader(onSettingsClick: () -> Unit, onProfileClick: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = onSettingsClick) {
            Icon(
                Icons.Outlined.Settings,
                contentDescription = stringResource(R.string.settings),
                tint = MaterialTheme.colorScheme.primary
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(R.drawable.mintly_logo),
                contentDescription = null,
                modifier = Modifier
                    .size(32.dp)
                    .clip(MaterialTheme.shapes.small)
            )
            Spacer(Modifier.width(8.dp))
            Text("mintly", style = MaterialTheme.typography.headlineSmall)
        }
        IconButton(onClick = onProfileClick) {
            Icon(
                Icons.Outlined.AccountCircle,
                contentDescription = stringResource(R.string.profile),
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
private fun CompetitiveCard(onBattleClick: () -> Unit) {
    Card(
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
    ) {
        Column(Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(stringResource(R.string.competitive), style = MaterialTheme.typography.titleLarge)
                Text(
                    stringResource(R.string.season, 4),
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Spacer(Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RankBadge(points = 65, maxPoints = 100)
                Button(
                    onClick = onBattleClick,
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 8.dp)
                ) {
                    Text(stringResource(R.string.battle))
                }
                TeamGrid()
            }
        }
    }
}

@Composable
private fun RankBadge(points: Int, maxPoints: Int) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(contentAlignment = Alignment.Center) {
            CircularProgressIndicator(
                progress = { points / maxPoints.toFloat() },
                modifier = Modifier.size(48.dp),
                strokeWidth = 4.dp,
                trackColor = MaterialTheme.colorScheme.primaryContainer
            )
            Icon(
                Icons.Outlined.Shield,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(22.dp)
            )
        }
        Text(stringResource(R.string.rank_elite), style = MaterialTheme.typography.labelSmall)
        Text(
            stringResource(R.string.points, points, maxPoints),
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
private fun TeamGrid() {
    val teamIcons: List<ImageVector> = listOf(
        Icons.Outlined.WaterDrop, Icons.Outlined.DarkMode, Icons.Outlined.LocalFlorist,
        Icons.Outlined.Bolt, Icons.Outlined.WaterDrop, Icons.Outlined.Eco
    )
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(stringResource(R.string.your_team), style = MaterialTheme.typography.labelSmall)
        Spacer(Modifier.height(4.dp))
        teamIcons.chunked(3).forEach { row ->
            Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                row.forEach { icon ->
                    Surface(
                        shape = MaterialTheme.shapes.small,
                        color = MaterialTheme.colorScheme.background,
                        modifier = Modifier.size(28.dp)
                    ) {
                        Icon(
                            icon,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.padding(5.dp)
                        )
                    }
                }
            }
            Spacer(Modifier.height(4.dp))
        }
    }
}