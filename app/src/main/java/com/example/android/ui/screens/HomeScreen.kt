package com.example.android.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.android.ui.components.Greeting
import com.example.android.ui.components.common.Container

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen() {
    Container {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            Greeting(
                name = "User",
            )
        }
    }
}

