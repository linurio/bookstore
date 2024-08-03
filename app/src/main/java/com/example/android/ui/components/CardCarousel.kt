package com.example.android.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import kotlin.math.abs

data class CarouselItem(val imageUrl: String);

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CardCarousel(items: List<CarouselItem>) {
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { items.count() })

    HorizontalPager(
        state = pagerState,
        contentPadding = PaddingValues(horizontal = 80.dp),
    ) { page ->
        BookCoverCard(items[page].imageUrl, pagerState.currentPage == page)
    }
}

//LazyRow(
//horizontalArrangement = Arrangement.spacedBy((-60).dp), // Negative space to overlap items
//contentPadding = PaddingValues(horizontal = 60.dp), // Padding to center the selected item
//modifier = Modifier
//.fillMaxWidth()
//.pointerInput(Unit) {
//    detectTransformGestures { _, pan, zoom, _ ->
//        if (zoom != 1f || abs(pan.x) > 0) {
//            isDragging = true
//        } else {
//            isDragging = false
//        }
//    }
//}
//) {
//    itemsIndexed(items) { index, item ->
//        val scale = if (index == selectedIndex) 1f else 0.8f
//
//        Box(
//            modifier = Modifier
//                .graphicsLayer {
//                    scaleX = scale
//                    scaleY = scale
//                }
//                .pointerInput(Unit) {
//                    detectTapGestures(
//                        onTap = {
//                            selectedIndex = index
//                        }
//                    )
//                }
//                .padding(16.dp)
//        ) {
//            BookCoverCard(item.imageUrl)
//        }
//    }
//}
