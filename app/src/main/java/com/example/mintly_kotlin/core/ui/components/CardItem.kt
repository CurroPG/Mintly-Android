package com.example.mintly_kotlin.core.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.mintly_kotlin.R
import com.example.mintly_kotlin.data.Card as PokemonCard // pongo este nombre para que no haya conflicto

@Composable
fun CardItem(
    card: PokemonCard,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    showStats: Boolean = false
) {
    Card(
        onClick = onClick,
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(card.image), // para poner la imagen
                contentDescription = card.name,
                contentScale = ContentScale.Crop,
                alignment = Alignment.TopCenter,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1.3f) // tamaño
                    .clip(MaterialTheme.shapes.small) // esquinas redondeadas
                    .background(MaterialTheme.colorScheme.primaryContainer) // y por ultimo pinta el fondo
            )
            Spacer(Modifier.height(8.dp))
            Text(
                card.name,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis // para que si el texto es muy largo lo corte con ...
            )
            Text(
                stringResource(R.string.level_rarity, card.level, card.rarity),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            if (showStats) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(top = 6.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(stringResource(R.string.hp_value, card.hp), style = MaterialTheme.typography.bodySmall)
                    Text(
                        stringResource(R.string.attack_value, card.attack),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            } else {
                Text(
                    card.price.toEuros(),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}