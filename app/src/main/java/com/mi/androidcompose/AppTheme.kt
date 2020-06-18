package com.mi.androidcompose

import androidx.compose.Composable
import androidx.ui.foundation.Text
import androidx.ui.graphics.Color
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Scaffold
import androidx.ui.material.TopAppBar
import androidx.ui.material.lightColorPalette
import androidx.ui.unit.dp

private val themeColors = lightColorPalette(
    primary = Color.DarkGray,
    surface = Color.DarkGray,
    onSurface = Color.White
)

@Composable
fun AppTheme(content: @Composable() () -> Unit) {
    MaterialTheme(colors = themeColors) {
        Scaffold(
            topAppBar = {
                TopAppBar(
                    title = { Text(text = "Articles") },
                    elevation = 12.dp
                )
            },
            bodyContent = {content()}
        )
    }
}