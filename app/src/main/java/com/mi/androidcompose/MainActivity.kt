package com.mi.androidcompose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.ContentScale
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.layout.*
import androidx.ui.res.imageResource
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
        val image = imageResource(id = R.drawable.header)
        val imageModifier = Modifier.preferredHeightIn(maxHeight = 180.dp).fillMaxWidth()

        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                modifier = imageModifier,
                contentScale = ContentScale.Crop,
                asset = image
            )
            Spacer(modifier = Modifier.preferredHeight(16.dp))
            Text("A day in Shark Fin Cove")
            Text("Davenport, California")
            Text("December 2018")
        }
    }

    @Preview
    @Composable
    fun DefaultPreview() {
        NewsStory()
    }

}
