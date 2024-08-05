package com.example.android.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.android.R
import com.example.android.ui.components.common.BookTypeButton

@Composable
fun BookTypeFilter() {
    Row(
        Modifier
            .padding(top = 10.dp)
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        BookTypeButton(
            "Paper",
            ImageVector.vectorResource(R.drawable.outline_book_2_24),
            Modifier.weight(1f)
        )
        Spacer(Modifier.width(10.dp))
        BookTypeButton(
            "Digital",
            ImageVector.vectorResource(R.drawable.outline_phone_iphone_24),
            Modifier.weight(1f)
        )
        Spacer(Modifier.width(10.dp))
        BookTypeButton(
            "Audio",
            ImageVector.vectorResource(R.drawable.outline_headphones_24),
            Modifier.weight(1f)
        )
    }
}
