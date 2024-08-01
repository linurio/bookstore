package com.example.android.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp

enum class IconVariant {
    Filled,
    Outlined
}

@Composable
fun BaseIcon(
    filled: Int,
    outlined: Int,
    size: Int,
    modifier: Modifier = Modifier,
    variant: IconVariant
) {
    val res = if (variant == IconVariant.Filled) filled else outlined
    val icon: ImageVector = ImageVector.vectorResource(res)

    Icon(
        imageVector = icon,
        contentDescription = null,
        tint = if (variant == IconVariant.Filled) {
            MaterialTheme.colorScheme.primary
        } else {
            MaterialTheme.colorScheme.onBackground
        },
        modifier = modifier.size(size.dp)
    )
}
