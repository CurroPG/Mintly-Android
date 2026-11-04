package com.example.mintly_kotlin.core.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NorthEast
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// para que cuando genere las cartas se ordenen en horizontal y el titulo quede a la izquierda
@Composable
fun SectionHeader(
    title: String,
    actionText: String,
    onAction: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(title, style = MaterialTheme.typography.titleLarge)
        TextButton(onClick = onAction) {
            Text(actionText, style = MaterialTheme.typography.bodySmall)
            Icon(Icons.Default.NorthEast, contentDescription = null, modifier = Modifier.size(14.dp))
        }
    }
}