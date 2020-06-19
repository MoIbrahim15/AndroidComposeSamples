package com.mi.androidcompose.views

import androidx.compose.Composable
import androidx.ui.foundation.Icon
import androidx.ui.foundation.Text
import androidx.ui.material.DrawerState
import androidx.ui.material.IconButton
import androidx.ui.material.TopAppBar
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.Info
import androidx.ui.material.icons.filled.Menu
import androidx.ui.unit.dp

@Composable
fun TopBar(
    onStateChange: (DrawerState) -> Unit
) {
    TopAppBar(
        title = { Text(text = "Articles") },
        navigationIcon = {
            IconButton(onClick = {
                onStateChange(DrawerState.Opened)
            }) {
                Icon(Icons.Filled.Menu)
            }
        },
        actions = {
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(Icons.Filled.Info)
            }
        },
        elevation = 12.dp
    )
}