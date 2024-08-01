package com.example.android.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.android.R

data class NavbarItemData(
    val icon: @Composable (Boolean) -> Unit,
    val dest: String,
)

const val DEBUG = false
val DEBUG_BORDER = if (DEBUG) 0x50FF0000 else 0x00FF0000

@Composable()
fun Navbar(modifier: Modifier = Modifier, navController: NavController) {
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStackEntry?.destination
    val activeItem = currentDestination?.route

    val items = listOf(
        NavbarItemData(
            icon = { isActive ->
                NavbarIcon(
                    isActive = isActive,
                    icons = Icons(
                        filled = R.drawable.house_filled,
                        outlined = R.drawable.house_outlined
                    ),
                )
            },
            dest = "Home"
        ),
        NavbarItemData(
            icon = { isActive ->
                NavbarIcon(
                    isActive = isActive,
                    icons = Icons(
                        filled = R.drawable.search_filled,
                        outlined = R.drawable.search_outlined
                    ),
                )
            },
            dest = "Search"
        ),
        NavbarItemData(
            icon = { isActive ->
                NavbarIcon(
                    isActive = isActive,
                    icons = Icons(
                        filled = R.drawable.cart_filled,
                        outlined = R.drawable.cart_outlined
                    ),
                )
            },
            dest = "Cart"
        ),
        NavbarItemData(
            icon = { isActive ->
                NavbarIcon(
                    isActive = isActive,
                    icons = Icons(
                        filled = R.drawable.user_filled,
                        outlined = R.drawable.user_outlined
                    ),
                )
            },
            dest = "Profile"
        ),
    )

    Box(
        modifier = Modifier
            .padding(bottom = 10.dp)
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(MaterialTheme.colorScheme.secondary)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(28.dp, 12.dp)
                    .border(width = 1.dp, color = Color(DEBUG_BORDER)), // DEBUG
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                items.forEach { item ->
                    NavbarItem(
                        icon = { item.icon(item.dest.lowercase() == activeItem) },
                        dest = item.dest,
                        isActive = item.dest.lowercase() == activeItem,
                        onClick = { dest ->
                            if (dest.lowercase() != currentDestination?.route) {
                                navController.navigate(dest.lowercase()) {
                                    popUpTo(navController.graph.startDestinationId) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}
