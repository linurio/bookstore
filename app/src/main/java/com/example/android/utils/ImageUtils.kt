package com.example.android.utils

import android.graphics.drawable.BitmapDrawable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.palette.graphics.Palette
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.request.SuccessResult
import kotlinx.coroutines.launch

@Composable
fun getVibrantColor(imageUrl: String): Color {
    var vibrantColor by remember { mutableStateOf(Color.White) }
    val context = LocalContext.current

    val imageLoader = ImageLoader(context)

    val request = ImageRequest.Builder(context)
        .data(imageUrl)
        .allowHardware(false)
        .build()

    val imagePainter = rememberAsyncImagePainter(
        ImageRequest.Builder(context)
            .data(imageUrl)
            .build()
    )

    LaunchedEffect(imagePainter) {
        launch {
            val result = (imageLoader.execute(request) as SuccessResult).drawable
            val bitmap = (result as BitmapDrawable).bitmap
            val vibrant = Palette.from(bitmap)
                .generate()
                .getVibrantColor(Color.Transparent.toArgb())
            vibrantColor = Color(vibrant)
        }
    }

    return vibrantColor
}