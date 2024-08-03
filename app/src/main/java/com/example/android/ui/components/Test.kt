package com.example.android.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android.ui.theme.AndroidTheme

@Composable
fun Test(modifier: Modifier) {
    Text(text = "test", modifier = Modifier.background(Color.White).padding(110.dp))
}

@Preview
@Composable
fun TestPreview() {
    AndroidTheme {
        Test(modifier = Modifier.padding(110.dp))
    }
}