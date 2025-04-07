package com.example.littlelemoncompose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemoncompose.R
import com.example.littlelemoncompose.data.categoryList
import com.example.littlelemoncompose.data.dishMenuList
import com.example.littlelemoncompose.ui.theme.LittleLemonComposeTheme

@Composable
fun LowerPanel() {
    Column(modifier = Modifier.padding(8.dp)) {
        WeeklySpecialCard()
        CategoryList()
        MenuList()
    }
}

@Composable
fun CategoryList() {
    LazyRow(
        state = rememberLazyListState(), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        items(categoryList) { categoryList ->
            ButtonCategoryItem(categoryList.name)
        }
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
fun MenuList() {
    LazyColumn(state = rememberLazyListState()) {
        items(dishMenuList) { dish ->
            CardMenuDish(
                name = dish.tittle,
                description = dish.description,
                price = dish.price,
                imageResource = painterResource(dish.image)
            )
            HorizontalDivider(
                thickness = 1.dp, color = Color.Gray
            )
        }
    }
}

@Composable
fun CardMenuDish(
    name: String,
    description: String,
    price: String,
    imageResource: Painter,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier.padding(4.dp), colors = CardDefaults.cardColors(
            containerColor = Color.Transparent, contentColor = Color.Gray
        ), shape = RoundedCornerShape(0)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)

        ) {
            Column(
                modifier = modifier
                    .fillMaxWidth(.7f)
                    .padding(end = 8.dp)
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
                painter = imageResource, contentDescription = "dish picture"
            )
        }
    }
}

@Composable
fun ButtonCategoryItem(name: String) {
    Button(
        onClick = {}, colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF495E57),
        ), modifier = Modifier
            //.background(Color.Gray)
            .padding(4.dp)
            .clip(RoundedCornerShape(4.dp))
    ) {
        Text(text = name, fontWeight = FontWeight.SemiBold)
    }
}

@Preview(showBackground = true)
@Composable
fun LowerPanelPreview() {
    LittleLemonComposeTheme {
        LowerPanel()
    }
}