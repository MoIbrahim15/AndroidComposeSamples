package com.mi.androidcompose.views

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.Box
import androidx.ui.foundation.ContentGravity
import androidx.ui.foundation.Text
import androidx.ui.graphics.Color
import androidx.ui.layout.fillMaxWidth
import androidx.ui.material.Button
import androidx.ui.unit.dp


@Composable
fun Counter(count: Int, updateCount: (Int) -> Unit) {
    Box(Modifier.fillMaxWidth(), gravity = ContentGravity.Center, padding = 16.dp) {
        Button(
            onClick = { updateCount(count + 1) },
            backgroundColor = Color.Gray
        ) {
            Text("I've been clicked ${count} times")
        }
    }
}