package com.mi.androidcompose.views

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
import androidx.ui.material.BottomAppBar
import androidx.ui.material.BottomNavigationItem
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.FavoriteBorder
import androidx.ui.material.icons.filled.Home
import androidx.ui.material.icons.filled.Settings
import androidx.ui.material.icons.filled.Share
import com.mi.androidcompose.models.BottomBarItem

private val bottomBarItems = listOf(
    BottomBarItem("Home", Icons.Filled.Home),
    BottomBarItem(
        "Favorites",
        Icons.Filled.FavoriteBorder
    ),
    BottomBarItem(
        "Settings",
        Icons.Filled.Settings
    ),
    BottomBarItem("Share", Icons.Filled.Share)
)

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