package com.example.android.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.android.ui.screens.CartScreen
import com.example.android.ui.screens.HomeScreen
import com.example.android.ui.screens.SearchScreen
import com.example.android.ui.screens.UserProfileScreen
import com.example.android.ui.theme.AndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidTheme(dynamicColor = false) {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "home",
                    enterTransition = {
                        EnterTransition.None
                    },
                    exitTransition = {
                        ExitTransition.None
                    }
                ) {
                    composable("home") { HomeScreen(navController) }
                    composable("search") { SearchScreen(navController) }
                    composable("cart") { CartScreen(navController) }
                    composable("profile") { UserProfileScreen(navController) }
                }

            }
        }
    }
}
