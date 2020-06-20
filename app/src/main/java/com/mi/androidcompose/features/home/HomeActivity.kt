package com.mi.androidcompose.features.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.setContent
import androidx.ui.foundation.VerticalScroller
import androidx.ui.tooling.preview.Preview
import com.mi.androidcompose.R
import com.mi.androidcompose.views.CardItem
import com.mi.androidcompose.models.Article
import com.mi.androidcompose.theme.AppTheme

class HomeActivity : AppCompatActivity() {

    private val article = Article(
        R.drawable.aricle1,
        "A day wandering through the sandhills in Shark Fin Cove, and a few of the sights I saw",
        mutableListOf("Davenport, California", "December 2018")
    )
    private val article2 = Article(
        R.drawable.aricle2,
        "A day wandering through the sandhills in Shark Fin Cove, and a few of the sights I saw",
        mutableListOf("Davenport, California", "December 2018")
    )
    private val articleItems = mutableListOf(article, article2)

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

    @Preview
    @Composable
    fun DefaultPreview() {
        NewsStory()
    }

}