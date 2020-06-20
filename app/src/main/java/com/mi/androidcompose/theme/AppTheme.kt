package com.mi.androidcompose.theme

import android.widget.Toast
import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.ContextAmbient
import androidx.ui.core.Modifier
import androidx.ui.foundation.Icon
import androidx.ui.foundation.drawBackground
import androidx.ui.foundation.shape.corner.CircleShape
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.Spacer
import androidx.ui.layout.fillMaxSize
import androidx.ui.layout.preferredHeight
import androidx.ui.material.*
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.*
import androidx.ui.unit.dp
import com.mi.androidcompose.AppStatus
import com.mi.androidcompose.Screen
import com.mi.androidcompose.models.MenuItem
import com.mi.androidcompose.views.BottomBar
import com.mi.androidcompose.views.DrawerButton
import com.mi.androidcompose.views.TopBar

private val themeColors = lightColorPalette(
    primary = Color.DarkGray,
    surface = Color.DarkGray,
    onSurface = Color.White
)

@Composable
fun AppTheme(featureContent: @Composable() () -> Unit) {
    MaterialTheme(colors = themeColors) {
        AppDrawer(featureContent)
    }
}

@Composable
fun AppDrawer(featureContent: @Composable() () -> Unit) {
    val (state, onStateChange) = state { DrawerState.Closed }
    ModalDrawerLayout(
        drawerState = state,
        onStateChange = onStateChange,
        drawerContent = {
            DrawerContent(
                onStateChange = onStateChange,
                currentScreen = AppStatus.currentScreen
            )
        },
        bodyContent = {
            AppContent(
                content = featureContent,
                onStateChange = onStateChange
            )
        },
        drawerElevation = 8.dp,
        drawerShape = MaterialTheme.shapes.small
    )
}

private val drawerItems = listOf(
    MenuItem(
        title = "Home",
        icon = Icons.Filled.Home,
        currentScreen = Screen.Home
    ),
    MenuItem(
        title = "Favorites",
        icon = Icons.Filled.FavoriteBorder,
        currentScreen = Screen.Favorites
    ),
    MenuItem(
        title = "Settings",
        icon = Icons.Filled.Settings,
        currentScreen = Screen.Settings
    ),
    MenuItem(
        title = "Share",
        icon = Icons.Filled.Share,
        currentScreen = Screen.Share
    )
)

@Composable
fun DrawerContent(
    currentScreen: Screen,
    onStateChange: (DrawerState) -> Unit
) {
    Column(modifier = Modifier.fillMaxSize().drawBackground(color = Color.White)) {
        Spacer(Modifier.preferredHeight(24.dp))
        drawerItems.forEach { item ->
            DrawerButton(
                icon = item.icon,
                label = item.title,
                isSelected = currentScreen == item.currentScreen,
                action = {
                    item.action?.invoke()
                    onStateChange(DrawerState.Closed)
                }
            )
        }
    }
}

@Composable
fun AppContent(
    content: @Composable() () -> Unit,
    onStateChange: (DrawerState) -> Unit
) {
    val context = ContextAmbient.current
    Scaffold(
        topAppBar = { TopBar(onStateChange) },
        bottomAppBar = { fabConfiguration ->
            BottomBar(
                fabConfiguration
            )
        },
        bodyContent = { content() },
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