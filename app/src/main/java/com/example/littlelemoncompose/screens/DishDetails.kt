package com.example.littlelemoncompose.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.littlelemoncompose.Home
import com.example.littlelemoncompose.R
import com.example.littlelemoncompose.navigation.MyBottomNavbar
import com.example.littlelemoncompose.navigation.TopAppBar
import com.example.littlelemoncompose.data.DishRepository
import com.example.littlelemoncompose.ui.theme.LittleLemonColors
import com.example.littlelemoncompose.ui.theme.Shapes
import java.util.Locale

@Composable
fun DishDetails(dishId: String?, navController: NavHostController) {
    val context = LocalContext.current
    val dish = DishRepository.getDish(Integer.parseInt(dishId!!))
    var counter by rememberSaveable {
        mutableIntStateOf(1)
    }

    Scaffold(topBar = { TopAppBar() }, bottomBar = {
        MyBottomNavbar(navController = navController)
    }, floatingActionButton = {
        Button(
            onClick = {
                navController.navigate(Home.route + "/admin")
                Toast.makeText(
                    context, R.string.order_finish_message, Toast.LENGTH_SHORT
                ).show()
            }, shape = Shapes.small, modifier = Modifier.fillMaxWidth(.92f)
        ) {
            Text(
                text = "${stringResource(R.string.add_for)} $${
                    (dish!!.price * counter).let { String.format(Locale.US, "%.2f", it).toDouble() }
                }",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                color = LittleLemonColors.green,
            )
        }
    }, modifier = Modifier.systemBarsPadding()) { it ->
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(dish!!.imageResource),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                item {
                    Text(
                        text = dish.name,
                        style = MaterialTheme.typography.headlineLarge,
                        color = Color.Black

                    )
                }
                item {
                    Text(
                        text = dish.description,
                        style = MaterialTheme.typography.bodyMedium,
                    )
                }
                item {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(20.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        IconButton(onClick = {
                            if (counter > 1) --counter
                        }) {
                            Text(
                                text = "-",
                                style = MaterialTheme.typography.bodyLarge,
                                textAlign = TextAlign.Center
                            )
                        }
                        Text(
                            text = counter.toString(),
                            style = MaterialTheme.typography.bodyLarge,
                            textAlign = TextAlign.Center
                        )

                        IconButton(onClick = { ++counter }) {
                            Text(
                                text = "+",
                                style = MaterialTheme.typography.bodyLarge,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DishDetailsPreview() {
    //DishDetails("1", NavHostController())
}