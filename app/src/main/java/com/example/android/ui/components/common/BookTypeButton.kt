package com.example.android.ui.components.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android.domain.constants.COLORS

@Composable
fun BookTypeButton(text: String, icon: ImageVector, modifier: Modifier = Modifier) {
    OutlinedButton(
        onClick = { /*TODO*/ },
        border = BorderStroke(2.dp, COLORS.secondary),
        shape = RoundedCornerShape(50.dp),
        contentPadding = PaddingValues(5.dp, 10.dp),
        modifier = modifier,
        colors = ButtonColors(
            contentColor = COLORS.onBackground,
            disabledContentColor = COLORS.onBackground,
            containerColor = COLORS.background,
            disabledContainerColor = COLORS.surface
        ),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(imageVector = icon, contentDescription = null)
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = text,
                fontSize = 14.sp
            )
        }
    }
}
