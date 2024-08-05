package com.example.android.ui.screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android.authors
import com.example.android.bestsellers
import com.example.android.fantasy
import com.example.android.scifi
import com.example.android.showcaseItems
import com.example.android.ui.components.AuthorCard
import com.example.android.ui.components.BookCoverCard
import com.example.android.ui.components.BookTypeFilter
import com.example.android.ui.components.Carousel
import com.example.android.ui.components.Greeting
import com.example.android.ui.components.Showcase

@Composable
fun HomeScreen(scrollState: ScrollState) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Top,
    ) {
        Greeting(
            name = "User", // TODO: replace with actual user name
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        BookTypeFilter()
        Spacer(Modifier.height(30.dp))
        Showcase(showcaseItems)
        Text(
            text = "Bestsellers",
            fontSize = 18.sp,
            fontWeight = FontWeight(300),
            modifier = Modifier.padding(20.dp, 20.dp, 20.dp, 10.dp)
        )
        Carousel {
            itemsIndexed(bestsellers) { _, item ->
                BookCoverCard(
                    item,
                    Modifier
                        .height(200.dp)
                        .width(130.dp),
                    onClick = { /*TODO*/ }
                )
            }
        }

        Text(
            text = "Famous authors",
            fontSize = 18.sp,
            fontWeight = FontWeight(300),
            modifier = Modifier.padding(20.dp, 20.dp, 20.dp, 10.dp)
        )
        Carousel {
            itemsIndexed(authors) { _, item ->
                AuthorCard(
                    item,
                    Modifier
                        .height(100.dp)
                        .width(100.dp),
                    onClick = { /*TODO*/ }
                )
            }
        }

        Text(
            text = "Fantasy",
            fontSize = 18.sp,
            fontWeight = FontWeight(300),
            modifier = Modifier.padding(20.dp, 20.dp, 20.dp, 10.dp)
        )
        Carousel {
            itemsIndexed(fantasy) { _, item ->
                BookCoverCard(
                    item,
                    Modifier
                        .height(200.dp)
                        .width(130.dp),
                    onClick = { /*TODO*/ }
                )
            }
        }

        Text(
            text = "Sci-Fi",
            fontSize = 18.sp,
            fontWeight = FontWeight(300),
            modifier = Modifier.padding(20.dp, 20.dp, 20.dp, 10.dp)
        )
        Carousel {
            itemsIndexed(scifi) { _, item ->
                BookCoverCard(
                    item,
                    Modifier
                        .height(200.dp)
                        .width(130.dp),
                    onClick = { /*TODO*/ }
                )
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
    }
}