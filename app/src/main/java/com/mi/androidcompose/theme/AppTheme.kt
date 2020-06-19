package com.mi.androidcompose.theme

import android.widget.Toast
import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.ContextAmbient
import androidx.ui.foundation.Icon
import androidx.ui.foundation.shape.corner.CircleShape
import androidx.ui.graphics.Color
import androidx.ui.material.*
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.Add
import androidx.ui.unit.dp
import com.mi.androidcompose.views.BottomBar
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
        drawerContent = { DrawerContent(onStateChange = onStateChange) },
        bodyContent = {
            AppContent(
                content = featureContent,
                onStateChange = onStateChange
            )
        },
        drawerElevation = 8.dp,
        drawerShape = MaterialTheme.shapes.large
    )
}

@Composable
fun DrawerContent(onStateChange: (DrawerState) -> Unit) {
    //todo
//    OutlinedButton(onClick = { Log.v("Test", "Test33333") }) {
//        Text("Outlined Button")
//    }
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