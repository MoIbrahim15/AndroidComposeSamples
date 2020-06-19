package com.mi.androidcompose.theme

import android.widget.Toast
import androidx.compose.Composable
import androidx.ui.core.ContextAmbient
import androidx.ui.foundation.Icon
import androidx.ui.foundation.shape.corner.CircleShape
import androidx.ui.graphics.Color
import androidx.ui.material.*
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.*
import com.mi.androidcompose.views.BottomBar
import com.mi.androidcompose.views.TopBar

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
            bottomAppBar = { fabConfiguration ->
                BottomBar(
                    fabConfiguration
                )
            },
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