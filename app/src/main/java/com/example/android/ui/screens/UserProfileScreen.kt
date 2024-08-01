package com.example.android.ui.screens

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.android.ui.components.Container
import com.example.android.ui.components.Navbar

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun UserProfileScreen(
    navController: NavController
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            Box(modifier = Modifier.padding(20.dp)) {
                Navbar(navController = navController)
            }
        }
    ) { innerPadding ->
        Container {
            Column(
                modifier = Modifier.fillMaxSize(),
            ) {
                Text(text = "User profile screen", Modifier.padding(innerPadding))
            }
        }
    }
}

