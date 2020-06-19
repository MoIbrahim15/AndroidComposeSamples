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

private val bottomBarItems = listOf(
    BottomBarItem("Home", Icons.Filled.Home),
    BottomBarItem("Favorites", Icons.Filled.FavoriteBorder),
    BottomBarItem("Settings", Icons.Filled.Settings),
    BottomBarItem("Share", Icons.Filled.Share)
)

@Composable
fun AppTheme(content: @Composable() () -> Unit) {
    MaterialTheme(colors = themeColors) {
        val context = ContextAmbient.current

        Scaffold(
            topAppBar = { TopBar() },
            bodyContent = { content() },
            bottomAppBar = { fabConfiguration -> BottomBar(fabConfiguration) },
            floatingActionButton = {
                FloatingActionButton(
                    contentColor = Color.White,
                    backgroundColor = Color.DarkGray,
                    icon = { Icon(Icons.Filled.Add) },
                    shape = CircleShape,
                    onClick = {
                        Toast.makeText(context, "FAB", Toast.LENGTH_SHORT).show()
                    }
                )
            },
            floatingActionButtonPosition = Scaffold.FabPosition.CenterDocked
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
@Composable
fun BottomBar(fabConfiguration: BottomAppBar.FabConfiguration?) {
    val selectedItem = state { 0 }
    BottomAppBar(
        fabConfiguration = fabConfiguration,
        cutoutShape = CircleShape,
        contentColor = Color.White,
        backgroundColor = Color.DarkGray
    ) {
        val context = ContextAmbient.current
        bottomBarItems.forEachIndexed { index, item ->
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
            if (index + 1 == bottomBarItems.size / 2) {
                Spacer(Modifier.weight(1f, true))
            }
        }
    }
}