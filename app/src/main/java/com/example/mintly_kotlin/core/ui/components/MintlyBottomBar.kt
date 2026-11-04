package com.example.mintly_kotlin.core.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mintly_kotlin.R

// la barra de abajo donde va el carrito, la camara y la pokeball
@Composable
fun MintlyBottomBar(
    cartCount: Int,
    onCartClick: () -> Unit,
    onPlayClick: () -> Unit,
    onCameraClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val buttonColors = IconButtonDefaults.filledIconButtonColors(
        containerColor = Color.White.copy(alpha = 0.1f),
        contentColor = MaterialTheme.colorScheme.inverseOnSurface
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp, vertical = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            shape = CircleShape,
            color = MaterialTheme.colorScheme.inverseSurface,
            shadowElevation = 8.dp // para meter sombra debajo y quede mas chulo
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                FilledIconButton(onClick = onCartClick, colors = buttonColors) {
                    BadgedBox(
                        badge = {
                            if (cartCount > 0) {
                                Badge(containerColor = MaterialTheme.colorScheme.primary) {
                                    Text("$cartCount")
                                }
                            }
                        }
                    ) {
                        Icon(Icons.Outlined.ShoppingCart, contentDescription = stringResource(R.string.cart))
                    }
                }
                FilledIconButton(onClick = onCameraClick, colors = buttonColors) {
                    Icon(Icons.Outlined.CameraAlt, contentDescription = stringResource(R.string.scan_card))
                }
            }
        }
        PokeballButton(onClick = onPlayClick, modifier = Modifier.size(76.dp))
    }
}

// boton con imagen subida de la pokeball para quitarnos de problemas
@Composable
private fun PokeballButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    IconButton(onClick = onClick, modifier = modifier) {
        Image(
            painter = painterResource(R.drawable.pokeball),
            contentDescription = stringResource(R.string.play),
            modifier = Modifier.fillMaxSize()
        )
    }
}