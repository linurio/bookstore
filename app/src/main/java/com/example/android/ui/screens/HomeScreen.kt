package com.example.android.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android.R
import com.example.android.domain.constants.COLORS
import com.example.android.ui.components.CardCarousel
import com.example.android.ui.components.CarouselItem
import com.example.android.ui.components.Greeting
import com.example.android.ui.theme.AndroidTheme

@Composable
fun HomeScreen(scrollState: ScrollState) {
    val carouselItems = listOf(
        CarouselItem("https://www.orbitbooks.net/wp-content/uploads/2022/07/3-BaptismFire_HC-scaled.jpg"),
        CarouselItem("https://www.orbitbooks.net/wp-content/uploads/2022/07/3-BaptismFire_HC-scaled.jpg"),
        CarouselItem("https://www.orbitbooks.net/wp-content/uploads/2022/07/3-BaptismFire_HC-scaled.jpg"),
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Top,
    ) {
        Greeting(
            name = "User", // TODO: replace with actual user name
            modifier = Modifier.padding(horizontal = 20.dp)
        )
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
        Spacer(Modifier.height(20.dp))
        CardCarousel(carouselItems)
    }
}

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
