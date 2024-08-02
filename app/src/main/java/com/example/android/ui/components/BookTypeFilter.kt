package com.example.android.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import com.example.android.R

data class BookType(
    val icon: Any, // FIXME
    val label: String
)

@Composable
fun BookTypeFilter() {
    val items = listOf(
        BookType(
            icon = R.drawable.outline_book_2_24,
            label = "Paper Books"
        ),
        BookType(
            icon = R.drawable.outline_phone_iphone_24,
            label = "Paper Books"
        ),
        BookType(
            icon = R.drawable.outline_headphones_24,
            label = "Paper Books"
        ),
    )

    Box {
       
    }

}