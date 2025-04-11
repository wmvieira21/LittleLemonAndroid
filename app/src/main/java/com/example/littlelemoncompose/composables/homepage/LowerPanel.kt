package com.example.littlelemoncompose.composables.homepage

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.littlelemoncompose.DishDetails
import com.example.littlelemoncompose.R
import com.example.littlelemoncompose.data.Dish
import com.example.littlelemoncompose.data.DishRepository
import com.example.littlelemoncompose.data.categoryList
import com.example.littlelemoncompose.ui.theme.LittleLemonColors
import com.example.littlelemoncompose.ui.theme.LittleLemonComposeTheme

@Composable
fun LowerPanel(navController: NavHostController) {
    Column(modifier = Modifier.padding(8.dp)) {
        WeeklySpecialCard()
        CategoryList()
        MenuList(navController)
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
        style = MaterialTheme.typography.headlineLarge,
        modifier = Modifier.padding(8.dp)
    )
}

@Composable
fun MenuList(navController: NavHostController) {
    LazyColumn(state = rememberLazyListState()) {
        itemsIndexed(DishRepository.dishes) { _, dish ->
            CardMenuDish(
                dish, navController = navController
            )
            HorizontalDivider(
                thickness = 1.dp, color = LittleLemonColors.yellow
            )
        }
    }
}

@Composable
fun CardMenuDish(
    dish: Dish, navController: NavHostController
) {
    Card(
        onClick = {
            Log.d("AAA", "Click ${dish.id}")
            navController?.navigate(DishDetails.route + "/${dish.id}")
        }, modifier = Modifier.padding(4.dp), colors = CardDefaults.cardColors(
            containerColor = Color.Transparent, contentColor = LittleLemonColors.charcoal
        ), shape = RoundedCornerShape(0)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(.75f)
                    .padding(end = 8.dp)
            ) {
                Text(
                    text = dish.name,
                    style = MaterialTheme.typography.bodyLarge,
                    //fontSize = 24.sp,
                )
                Text(
                    text = dish.description,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)

                )
                Text(
                    text = "$${dish.price}",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold
                )
            }

            Image(
                painter = painterResource(dish.imageResource),
                contentDescription = "dish picture",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .height(100.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
        }
    }
}

@Composable
fun ButtonCategoryItem(name: String) {
    Button(
        onClick = {}, colors = ButtonDefaults.buttonColors(
            containerColor = LittleLemonColors.green,
        ), modifier = Modifier
            //.background(Color.Gray)
            .padding(4.dp)
            .clip(RoundedCornerShape(4.dp))
    ) {
        Text(text = name, style = MaterialTheme.typography.bodySmall)
    }
}

@Preview(showBackground = true)
@Composable
fun LowerPanelPreview() {
    LittleLemonComposeTheme {
        //LowerPanel()
    }
}