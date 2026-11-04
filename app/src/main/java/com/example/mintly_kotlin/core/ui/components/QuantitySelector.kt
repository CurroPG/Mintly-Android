package com.example.mintly_kotlin.core.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mintly_kotlin.R

// basicamente es el state hoisting del otro componente avisando con onDecrease y onIncrease
// sirve para cambiar la cantidad de manera accesible
// es el (-) 1 (+)
@Composable
fun QuantitySelector(
    quantity: Int,
    onDecrease: () -> Unit,
    onIncrease: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shape = MaterialTheme.shapes.small,
        color = MaterialTheme.colorScheme.background,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primaryContainer)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = onDecrease, modifier = Modifier.size(32.dp)) {
                Icon(
                    Icons.Default.Remove,
                    contentDescription = stringResource(R.string.decrease),
                    modifier = Modifier.size(16.dp)
                )
            }
            Text(
                "$quantity",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(horizontal = 12.dp)
            )
            IconButton(onClick = onIncrease, modifier = Modifier.size(32.dp)) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = stringResource(R.string.increase),
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }
}