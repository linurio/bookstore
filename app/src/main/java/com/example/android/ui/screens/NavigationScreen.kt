package com.example.android.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.android.R
import com.example.android.domain.constants.COLORS
import com.example.android.ui.components.navbar.Icons
import com.example.android.ui.components.navbar.Navbar
import com.example.android.ui.components.navbar.NavbarIconWrapper

data class NavbarItemData(
    val id: Int,
    val icon: @Composable (Boolean) -> Unit,
)

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun NavigationScreen() {
    val scrollState = rememberScrollState()
    var previousScrollPosition by remember { mutableIntStateOf(0) }
    var showBottomBar by remember { mutableStateOf(true) }

    LaunchedEffect(scrollState.value) {
        val currentScrollPosition = scrollState.value
        showBottomBar = when {
            currentScrollPosition < previousScrollPosition -> true
            currentScrollPosition > previousScrollPosition -> false
            else -> showBottomBar
        }
        previousScrollPosition = currentScrollPosition
    }

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

    val scrollBehavior = BottomAppBarDefaults.exitAlwaysScrollBehavior()

    Scaffold(
        containerColor = COLORS.background,
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        bottomBar = {
            Navbar(
                items,
                pagerState,
                scrollBehavior
            )
        },
    ) { innerPadding ->
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = innerPadding.calculateStartPadding(LayoutDirection.Ltr),
                    end = innerPadding.calculateEndPadding(LayoutDirection.Ltr),
                    top = innerPadding.calculateTopPadding(),
                    bottom = 0.dp
                ),
        ) { page ->
            when (page) {
                0 -> HomeScreen(scrollState)
                1 -> SearchScreen()
                2 -> CartScreen()
                3 -> UserProfileScreen()
            }
        }
    }
}
