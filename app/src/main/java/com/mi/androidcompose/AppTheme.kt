package com.mi.androidcompose

import androidx.compose.Composable
import androidx.ui.graphics.Color
import androidx.ui.material.MaterialTheme
import androidx.ui.material.lightColorPalette

private val themeColors = lightColorPalette(
    primary = Color.White,
    surface = Color.DarkGray,
    onSurface = Color.White
)

@Composable
fun AppTheme(content: @Composable() () -> Unit) {
    MaterialTheme(colors = themeColors) {
        content()
    }
}