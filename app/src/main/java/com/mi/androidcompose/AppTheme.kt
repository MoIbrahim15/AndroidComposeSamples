package com.mi.androidcompose

import androidx.compose.Composable
import androidx.ui.graphics.Color
import androidx.ui.material.MaterialTheme
import androidx.ui.material.lightColorPalette

val green = Color(0xFF1EB980)
private val themeColors = lightColorPalette(
    primary = green,
    surface = Color.DarkGray,
    onSurface = green
)

@Composable
fun AppTheme(content: @Composable() () -> Unit) {
    MaterialTheme(colors = themeColors) {
        content()
    }
}