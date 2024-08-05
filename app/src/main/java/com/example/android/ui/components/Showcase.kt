package com.example.android.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.example.android.BookCoverItem
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Showcase(items: List<BookCoverItem>) {
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { items.count() })
    val scope = rememberCoroutineScope()

    HorizontalPager(
        state = pagerState,
        contentPadding = PaddingValues(horizontal = 80.dp),
    ) { page ->
        val pageOffset = (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction

        val scale = 1f - 0.3f * pageOffset.absoluteValue.coerceIn(0f, 1f)
        val alphaValue = 1f - 0.3f * pageOffset.absoluteValue.coerceIn(0f, 1f)

        BookCoverCard(
            items[page],
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                    alpha = alphaValue
                },
            onClick = {
                scope.launch {
                    pagerState.animateScrollToPage(page)
                }
            }
        )
    }
}
