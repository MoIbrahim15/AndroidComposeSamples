package com.mi.androidcompose.views

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.Text
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.padding
import androidx.ui.material.Divider
import androidx.ui.material.MaterialTheme
import androidx.ui.unit.dp

@Composable
fun TextList(items: List<String>) {
    Column {
        items.forEachIndexed { index, item ->
            Text(
                item,
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(0.dp, 8.dp, 0.dp, 8.dp)
            )
            if (index != items.size - 1)
                Divider(color = Color.White)
        }
    }
}