package com.example.android.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.android.AuthorItem
import com.example.android.domain.constants.COLORS

@Composable
fun AuthorCard(
    card: AuthorItem,
    modifier: Modifier,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = modifier
                .border(
                    BorderStroke(
                        width = 3.dp,
                        color = COLORS.secondary,
                    ),
                    shape = RoundedCornerShape(100),
                )
                .padding(2.dp)
                .clip(RoundedCornerShape(100))
                .clickable(
                    interactionSource = interactionSource,
                    indication = rememberRipple(
                        bounded = false,
                        radius = 100.dp,
                        color = COLORS.onSecondary
                    ),
                ) {
                    onClick()
                }
        ) {
            AsyncImage(
                model = card.imageUrl,
                contentDescription = card.name,
                contentScale = ContentScale.FillBounds,
                alignment = Alignment.Center,
                clipToBounds = false,
            )
        }
        Text(
            text = card.name,
            fontSize = 12.sp
        )
    }

}
