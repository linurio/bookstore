package com.example.android.ui.components.navbar

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarScrollBehavior
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.android.domain.constants.COLORS
import com.example.android.ui.screens.NavbarItemData
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun Navbar(
    items: List<NavbarItemData>,
    pagerState: PagerState,
    scrollBehavior: BottomAppBarScrollBehavior,
) {
    val scope = rememberCoroutineScope()

    BottomAppBar(
        containerColor = Color.Transparent,
        contentColor = COLORS.onBackground,
        contentPadding = PaddingValues(horizontal = 30.dp),
        scrollBehavior = scrollBehavior,
        modifier = Modifier
            .background(
                Brush.verticalGradient(
                    0.2f to Color.Transparent,
                    1f to Color.Black.copy(alpha = .8f),
                )
            )
    ) {
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(COLORS.secondary)
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            items.forEach { item ->
                NavbarItem(
                    id = item.id,
                    icon = { item.icon(item.id == pagerState.currentPage) },
                    isActive = item.id == pagerState.currentPage,
                    onClick = { id ->
                        scope.launch {
                            pagerState.scrollToPage(id)
                        }
                    }
                )
            }
        }
    }
}
