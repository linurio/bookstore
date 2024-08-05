package com.example.android.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.android.BookCoverItem
import com.example.android.domain.constants.COLORS

@Composable
fun BookCoverCard(
    card: BookCoverItem,
    modifier: Modifier,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }

    Card(
        modifier = modifier
            .padding(2.dp)
            .border(
                BorderStroke(
                    width = 3.dp,
                    color = COLORS.secondary,
                ),
                shape = RoundedCornerShape(2),
            )
            .clip(RoundedCornerShape(2))
            .clickable(
                interactionSource = interactionSource,
                indication = rememberRipple(
                    bounded = false,
                    radius = 200.dp,
                    color = COLORS.onSecondary
                ),
            ) {
                onClick()
            }
    ) {
        AsyncImage(
            model = card.imageUrl,
            contentDescription = card.desc,
            contentScale = ContentScale.FillBounds,
            alignment = Alignment.Center,
            clipToBounds = false,
        )
    }
}