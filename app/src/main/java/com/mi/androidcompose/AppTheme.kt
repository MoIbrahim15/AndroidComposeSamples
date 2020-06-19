package com.mi.androidcompose

import android.widget.Toast
import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.ContextAmbient
import androidx.ui.core.Modifier
import androidx.ui.foundation.Icon
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.CircleShape
import androidx.ui.graphics.Color
import androidx.ui.layout.Spacer
import androidx.ui.material.*
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.*
import androidx.ui.unit.dp

private val themeColors = lightColorPalette(
    primary = Color.DarkGray,
    surface = Color.DarkGray,
    onSurface = Color.White
)

@Composable
fun AppTheme(content: @Composable() () -> Unit) {
    MaterialTheme(colors = themeColors) {
        val context = ContextAmbient.current

        Scaffold(
            topAppBar = { TopBar() },
            bodyContent = { content() },
            bottomAppBar = { BottomBar() }
        )
    }
}

@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = "Articles") },
        elevation = 12.dp
    )
}

val items = listOf(
    BottomBarItem("Home", Icons.Filled.Home),
    BottomBarItem("Favorites", Icons.Filled.FavoriteBorder),
    BottomBarItem("Settings", Icons.Filled.Settings),
    BottomBarItem("Share", Icons.Filled.Share)
)

@Composable
fun BottomBar() {
    val selectedItem = state { 0 }
    BottomAppBar(
        contentColor = Color.White,
        backgroundColor = Color.DarkGray
    ) {
        val context = ContextAmbient.current
        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                icon = { Icon(item.icon) },
                text = { Text(item.title) },
                selected = selectedItem.value == index,
                onSelected = {
                    selectedItem.value = index
                    Toast.makeText(context, item.title, Toast.LENGTH_SHORT).show()
                },
                activeColor = Color.Gray,
                inactiveColor = Color.White
            )
        }
    }
}