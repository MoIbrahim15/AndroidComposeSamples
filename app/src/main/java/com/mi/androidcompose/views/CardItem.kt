package com.mi.androidcompose.views

import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.ContentScale
import androidx.ui.core.Modifier
import androidx.ui.core.clip
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.layout.*
import androidx.ui.layout.ColumnScope.weight
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Surface
import androidx.ui.res.imageResource
import androidx.ui.text.style.TextOverflow
import androidx.ui.unit.dp
import com.mi.androidcompose.models.Article

@Composable
fun CardItem(item: Article) {
    val imageModifier = Modifier.preferredHeightIn(maxHeight = 180.dp)
        .fillMaxWidth()
        .clip(shape = RoundedCornerShape(8.dp))

    val count = state { 0 }
    Surface(
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp,
        modifier = Modifier.padding(16.dp, 8.dp, 16.dp, 8.dp)
    ) { // surface rounded courner
        Column(modifier = Modifier.padding(16.dp).weight(1f)) {
            Image(
                modifier = imageModifier,
                contentScale = ContentScale.Crop,
                asset = imageResource(id = item.imageID)
            )
            Spacer(modifier = Modifier.preferredHeight(16.dp))
            Text(
                item.title,
                style = MaterialTheme.typography.h6,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            TextList(item.textList)
            Counter(count = count.value,
                updateCount = { newCount ->
                    count.value = newCount
                })
        }
    }
}