package com.example.mintly_kotlin.core.ui.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.mintly_kotlin.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MintlyTopBar(
    title: String,
    onBack: () -> Unit,
    actions: @Composable RowScope.() -> Unit = {}
) {
    TopAppBar(
        title = { Text(title, style = MaterialTheme.typography.headlineSmall) },
        navigationIcon = {
            IconButton(onClick = onBack) {
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = stringResource(R.string.back)
                )
            }
        },
        actions = actions,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background
        )
    )
}

// para que cuando haya algo en el carrito salga el circulito
@Composable
fun CartBadgeIcon(count: Int, onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        BadgedBox(
            badge = {
                if (count > 0) {
                    Badge(containerColor = MaterialTheme.colorScheme.primary) {
                        Text("$count")
                    }
                }
            }
        ) {
            Icon(Icons.Outlined.ShoppingCart, contentDescription = stringResource(R.string.cart))
        }
    }
}
// contentDescription es como el label de html, es para que pueda leerlo en modo ciego