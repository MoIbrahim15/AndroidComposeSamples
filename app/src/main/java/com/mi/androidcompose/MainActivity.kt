package com.mi.androidcompose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.ContentScale
import androidx.ui.core.Modifier
import androidx.ui.core.clip
import androidx.ui.core.setContent
import androidx.ui.foundation.*
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.layout.ColumnScope.weight
import androidx.ui.material.Button
import androidx.ui.material.Divider
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Surface
import androidx.ui.res.imageResource
import androidx.ui.text.style.TextOverflow
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp

class MainActivity : AppCompatActivity() {

    private val article = Article(
        R.drawable.header,
        "A day wandering through the sandhills in Shark Fin Cove, and a few of the sights I saw",
        mutableListOf("Davenport, California", "December 2018")
    )
    private val articleItems = mutableListOf(article, article, article)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsStory()
        }
    }

    @Composable
    fun NewsStory() {
        AppTheme {
            VerticalScroller {
                for (item in articleItems) {
                    CardItem(item)
                }
            }
        }
    }

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
                ShowTextList(item.textList)
                Counter(count = count.value,
                    updateCount = { newCount ->
                        count.value = newCount
                    })
            }
        }
    }

    @Composable
    fun ShowTextList(items: List<String>) {
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

    @Preview
    @Composable
    fun DefaultPreview() {
        NewsStory()
    }

}