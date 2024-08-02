package com.example.android.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.android.ui.components.common.Container

@Composable
fun SearchScreen() {
    Container {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            Text(text = "Search screen")
        }
    }
}
