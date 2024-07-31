package com.example.android.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.android.ui.components.Container
import com.example.android.ui.components.Greeting
import com.example.android.ui.components.Navbar

@Composable
fun MainScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Container {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Greeting(
                    name = "User",
                    modifier = Modifier
                        .padding(innerPadding)
                )
                Navbar()
            }
        }
    }
}
