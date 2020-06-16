package com.mi.androidcompose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.ContentScale
import androidx.ui.core.Modifier
import androidx.ui.core.clip
import androidx.ui.core.setContent
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.Divider
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Typography
import androidx.ui.res.imageResource
import androidx.ui.text.style.TextOverflow
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsStory()
        }
    }

    @Composable
    fun NewsStory() {
        MaterialTheme {
            val typography = MaterialTheme.typography
            val image = imageResource(id = R.drawable.header)
            val imageModifier = Modifier.preferredHeightIn(maxHeight = 180.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(8.dp))
            Column(modifier = Modifier.padding(16.dp)) {
                Image(
                    modifier = imageModifier,
                    contentScale = ContentScale.Crop,
                    asset = image
                )
                Spacer(modifier = Modifier.preferredHeight(16.dp))
                Text(
                    "A day wandering through the sandhills " +
                            "in Shark Fin Cove, and a few of the " +
                            "sights I saw",
                    style = typography.h6,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                showItems(
                    listOf(
                        "Davenport, California",
                        "December 2018"
                    )
                    , typography = typography
                )
            }
        }
    }

    @Composable
    fun showItems(items: List<String>, typography: Typography) {
        Column {
            for (item in items) {
                Text(
                    item,
                    style = typography.body2
                )
                Divider(color = Color.Black)
            }
        }
    }

    @Preview
    @Composable
    fun DefaultPreview() {
        NewsStory()
    }

}
