package com.example.android.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.android.domain.constants.COLORS

@Composable
fun BookCoverCard(imageUrl: String, isActive: Boolean, modifier: Modifier = Modifier) {
    val scale = if (isActive) 1f else 0.8f

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(350.dp)
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
            }
            .clip(RoundedCornerShape(2))
            .padding(2.dp)
            .border(
                BorderStroke(width = 3.dp, color = COLORS.secondary),
                shape = RoundedCornerShape(3)
            )
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = "1984",
            contentScale = ContentScale.FillHeight,
            alignment = Alignment.Center,
            clipToBounds = false,
        )
    }
}