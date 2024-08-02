package com.example.android.ui.components.navbar

import androidx.compose.runtime.Composable

data class Icons(
    val filled: Int,
    val outlined: Int,
)

@Composable
fun NavbarIconWrapper(isActive: Boolean, icons: Icons, size: Int = 28) {
    NavbarIcon(
        filled = icons.filled,
        outlined = icons.outlined,
        size = size,
        variant = if (isActive) IconVariant.Filled else IconVariant.Outlined
    )
}