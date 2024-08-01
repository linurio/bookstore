package com.example.android.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

val darkColors = darkColorScheme(
    primary = Accent,
    secondary = DarkBackgroundSecondary,
    background = DarkBackground,
    surface = DarkBackgroundAlt,
    onPrimary = DarkText,
    onSecondary = DarkTextSecondary,
    onBackground = DarkText,
    onSurface = DarkTextSecondary
)

val lightColors = lightColorScheme(
    primary = Accent,
    secondary = White,
    background = LightBackground,
    surface = LightBackgroundSecondary,
    onPrimary = LightText,
    onSecondary = LightTextSecondary,
    onBackground = LightText,
    onSurface = LightTextSecondary
)

@Composable
fun AndroidTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> darkColors
        else -> lightColors
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}