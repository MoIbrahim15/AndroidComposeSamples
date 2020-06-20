package com.mi.androidcompose.models

import androidx.ui.graphics.vector.VectorAsset
import com.mi.androidcompose.Screen

data class MenuItem(
    val title: String,
    val icon: VectorAsset,
    val currentScreen: Screen? = null,
    val action: (() -> Unit)? = null
)