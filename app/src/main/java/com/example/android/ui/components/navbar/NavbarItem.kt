package com.example.android.ui.components.navbar

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.android.domain.constants.COLORS

@Composable
fun NavbarItem(
    id: Int,
    isActive: Boolean,
    onClick: (Int) -> Unit, modifier: Modifier = Modifier,
    icon: @Composable (Boolean) -> Unit,
) {
    // TODO: change to button
    Button(
        onClick = { onClick(id) },
        contentPadding = PaddingValues(0.dp),
        shape = RoundedCornerShape(10),
        colors = ButtonColors(
            contentColor = COLORS.onBackground,
            disabledContentColor = COLORS.onBackground,
            containerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent
        ),
    ) {
        icon(isActive)
    }
}
