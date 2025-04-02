package com.example.littlelemoncompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemoncompose.ui.theme.LittleLemonComposeTheme

@Composable
fun LowerPanel(modifier: Modifier = Modifier) {
    Column {
        WeeklySpecialCard()
        CardMenuDish(
            name = stringResource(R.string.dish_tittle_text),
            description = stringResource(R.string.dish_desc_text),
            price = stringResource(R.string.dish_price_text),
            imageResource = painterResource(R.drawable._b97d1aaeb0c85a7222b2a4f2553d496ed5bd115)
        )
    }
}

@Composable
fun WeeklySpecialCard() {
    Text(
        text = stringResource(R.string.card_tittle_text),
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(8.dp)
    )
}

@Composable
fun CardMenuDish(
    name: String,
    description: String,
    price: String,
    imageResource: Painter,
    modifier: Modifier = Modifier
) {
    Card {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Column(
                modifier = modifier.fillMaxWidth(.7f)
            ) {
                Text(
                    text = name, fontSize = 24.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = description, modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)

                )
                Text(text = price, fontWeight = FontWeight.Bold)
            }
            Image(
                painter = imageResource, contentDescription = ""
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun LowerPanelPreview() {
    LittleLemonComposeTheme {
        LowerPanel()
    }
}