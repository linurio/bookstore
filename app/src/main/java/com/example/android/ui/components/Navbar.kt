package com.example.android.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android.ui.theme.AndroidTheme

@Composable()
fun Navbar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp, 20.dp, 20.dp, 40.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text("+")
        Text("+")
        Text("+")
        Text("+")
    }
}

@Preview(showBackground = true)
@Composable
fun NavbarPreview() {
    AndroidTheme {
        Navbar()
    }
}
