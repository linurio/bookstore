package com.example.android.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.android.R
import com.example.android.ui.components.navbar.Icons
import com.example.android.ui.components.navbar.NavbarIconWrapper
import com.example.android.ui.components.navbar.NavbarItem
import kotlinx.coroutines.launch

data class NavbarItemData(
    val id: Int,
    val icon: @Composable (Boolean) -> Unit,
)

const val DEBUG = false
val DEBUG_BORDER = if (DEBUG) 0x50FF0000 else 0x00FF0000

@OptIn(ExperimentalFoundationApi::class)
@Composable()
fun NavigationScreen() {
    val scope = rememberCoroutineScope()

    val items = listOf(
        NavbarItemData(
            id = 0,
            icon = { isActive ->
                NavbarIconWrapper(
                    isActive = isActive,
                    icons = Icons(
                        filled = R.drawable.house_filled,
                        outlined = R.drawable.house_outlined
                    ),
                )
            },
        ),
        NavbarItemData(
            id = 1,
            icon = { isActive ->
                NavbarIconWrapper(
                    isActive = isActive,
                    icons = Icons(
                        filled = R.drawable.search_filled,
                        outlined = R.drawable.search_outlined
                    ),
                )
            },
        ),
        NavbarItemData(
            id = 2,
            icon = { isActive ->
                NavbarIconWrapper(
                    isActive = isActive,
                    icons = Icons(
                        filled = R.drawable.cart_filled,
                        outlined = R.drawable.cart_outlined
                    ),
                )
            },
        ),
        NavbarItemData(
            id = 3,
            icon = { isActive ->
                NavbarIconWrapper(
                    isActive = isActive,
                    icons = Icons(
                        filled = R.drawable.user_filled,
                        outlined = R.drawable.user_outlined
                    ),
                )
            },
        ),
    )
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { items.count() })

    Scaffold(
        bottomBar = {
            Box(modifier = Modifier.padding(20.dp)) {
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
                                id = item.id,
                                icon = { item.icon(item.id == pagerState.currentPage) },
                                isActive = item.id == pagerState.currentPage,
                                onClick = { id ->
                                    scope.launch {
                                        pagerState.animateScrollToPage(id)
                                    }
                                }
                            )
                        }
                    }
                }
            }
        },
    ) { innerPadding ->
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) { page ->
            when (page) {
                0 -> HomeScreen()
                1 -> SearchScreen()
                2 -> CartScreen()
                3 -> UserProfileScreen()
            }
        }
    }
}
