package com.mi.androidcompose.views

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.graphics.Color
import androidx.ui.graphics.ColorFilter
import androidx.ui.graphics.vector.VectorAsset
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.material.TextButton
import androidx.ui.unit.dp


@Composable
fun DrawerButton(
    icon: VectorAsset,
    label: String,
    isSelected: Boolean,
    action: () -> Unit) {
    val imageAlpha = if (isSelected) {
        1f
    } else {
        0.6f
    }
    val textIconColor = if (isSelected) {
        Color.DarkGray
    } else {
        Color.Gray
    }

    TextButton(
        onClick = action,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalGravity = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                asset = icon,
                colorFilter = ColorFilter.tint(textIconColor),
                alpha = imageAlpha
            )
            Spacer(Modifier.preferredWidth(16.dp))
            Text(
                text = label,
                style = MaterialTheme.typography.body2,
                color = textIconColor,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
