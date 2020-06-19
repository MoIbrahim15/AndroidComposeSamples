package com.mi.androidcompose.views

import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.foundation.Icon
import androidx.ui.foundation.Text
import androidx.ui.material.*
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.Menu
import androidx.ui.material.icons.filled.MoreVert
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

            val expanded = state { false }
            val iconButton = @Composable {
                IconButton(onClick = { expanded.value = true }) {
                    Icon(Icons.Default.MoreVert)
                }
            }
            DropdownMenu(
                expanded = expanded.value,
                onDismissRequest = { expanded.value = false },
                toggle = iconButton
            ) {
                DropdownMenuItem(onClick = { /* Handle refresh! */ }) {
                    Text("Refresh")
                }
                DropdownMenuItem(onClick = { /* Handle settings! */ }) {
                    Text("Settings")
                }
                Divider()
                DropdownMenuItem(onClick = { /* Handle send feedback! */ }) {
                    Text("Send Feedback")
                }
            }
        },
        elevation = 16.dp
    )
}