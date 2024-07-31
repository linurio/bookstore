package com.example.android.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android.ui.theme.AndroidTheme

@Composable()
fun Container(children: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .padding(20.dp)
    ) {
        children()
    }
}

@Preview(showBackground = true)
@Composable
fun ContainerPreview() {
    AndroidTheme {
        ContainerPreview()
    }
}
