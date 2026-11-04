package com.example.mintly_kotlin.core.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.mintly_kotlin.R
import com.example.mintly_kotlin.data.Product

@Composable
fun ProductCard(
    product: Product,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    showAddButton: Boolean = false,
    onAdd: () -> Unit = {}
) {
    Card(
        onClick = onClick,
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(Modifier.padding(8.dp)) {
            Box {
                Image(
                    painter = painterResource(product.image),
                    contentDescription = product.name,
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.TopCenter,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1.6f)
                        .clip(MaterialTheme.shapes.small)
                        .background(MaterialTheme.colorScheme.primaryContainer)
                )
                product.discount?.let { discount -> // solo si hay descuento, añade una etiqueta con ello
                    Surface(
                        color = MaterialTheme.colorScheme.primary,
                        shape = CircleShape,
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(6.dp)
                    ) {
                        Text(
                            "-$discount%",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                        )
                    }
                }
            }
            Spacer(Modifier.height(8.dp))
            Text(
                product.set.uppercase(),
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                product.name,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    product.price.toEuros(),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary
                )
                product.oldPrice?.let { old ->
                    Spacer(Modifier.width(6.dp))
                    Text(
                        old.toEuros(),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        textDecoration = TextDecoration.LineThrough // si hay descuento, tacha el precio antiguo
                    )
                }
                Spacer(Modifier.weight(1f))
                if (showAddButton) { // para añadir un boton con un + para añadir una unidad, accionando el carrito
                    FilledIconButton(
                        onClick = onAdd,
                        modifier = Modifier.size(28.dp),
                        colors = IconButtonDefaults.filledIconButtonColors(
                            containerColor = MaterialTheme.colorScheme.inverseSurface,
                            contentColor = MaterialTheme.colorScheme.inverseOnSurface
                        )
                    ) {
                        Icon(
                            Icons.Default.Add,
                            contentDescription = stringResource(R.string.add),
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }
        }
    }
}
// para que se pongan de dos en dos
// no se puede usar una cuadricula porque ya está en lazycolumn y no se puede otra
@Composable
fun ProductPairRow(
    products: List<Product>,
    onProductClick: (Product) -> Unit,
    modifier: Modifier = Modifier,
    showAddButton: Boolean = false,
    onAdd: (Product) -> Unit = {}
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        products.forEach { product ->
            ProductCard(
                product = product,
                onClick = { onProductClick(product) },
                modifier = Modifier.weight(1f),
                showAddButton = showAddButton,
                onAdd = { onAdd(product) }
            )
        }
        if (products.size == 1) {
            Spacer(Modifier.weight(1f))
        }
    }
}