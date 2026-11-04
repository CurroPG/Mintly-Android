package com.example.mintly_kotlin.core.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = MintGreen,
    onPrimary = Color.White,
    primaryContainer = MintLight,
    onPrimaryContainer = MintBlack,
    secondary = MintGreen,
    onSecondary = Color.White,
    secondaryContainer = MintPale,
    onSecondaryContainer = MintBlack,
    background = MintBackground,
    onBackground = MintBlack,
    surface = MintBackground,
    onSurface = MintBlack,
    surfaceVariant = MintPale,
    onSurfaceVariant = MintGray,
    surfaceContainerLowest = Color.White,
    surfaceContainerLow = MintPale,
    surfaceContainer = MintPale,
    surfaceContainerHigh = MintPale,
    surfaceContainerHighest = MintPale,
    inverseSurface = MintBlack,
    inverseOnSurface = Color.White,
    outline = MintLight,
    error = MintRemove
)

@Composable
fun MintlyKotlinTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        shapes = MintlyShapes,
        content = content
    )
}