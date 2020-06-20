package com.mi.androidcompose

import androidx.compose.frames.ModelList
import androidx.compose.getValue
import androidx.compose.mutableStateOf
import androidx.compose.setValue

/**
 * Class defining the screens we have in the app: home, favorites, settings and share
 */
sealed class Screen {
    object Home : Screen()
    object Favorites : Screen()
    object Settings : Screen()
    object Share : Screen()
}

object AppStatus {
    var currentScreen by mutableStateOf<Screen>(Screen.Home)

}

/**
 * Temporary solution pending navigation support.
 */
fun navigateTo(destination: Screen) {
    AppStatus.currentScreen = destination
}
