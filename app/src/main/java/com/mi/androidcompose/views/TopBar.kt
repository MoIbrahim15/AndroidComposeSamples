package com.mi.androidcompose.views

import androidx.compose.Composable
import androidx.ui.foundation.Text
import androidx.ui.material.TopAppBar
import androidx.ui.unit.dp

@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = "Articles") },
        elevation = 12.dp
    )
}