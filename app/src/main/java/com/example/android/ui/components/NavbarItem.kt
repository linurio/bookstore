package com.example.android.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun NavbarItem(
    dest: String,
    isActive: Boolean,
    onClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    icon: @Composable (Boolean) -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) { onClick(dest) }) {
        icon(isActive)
    }
}
