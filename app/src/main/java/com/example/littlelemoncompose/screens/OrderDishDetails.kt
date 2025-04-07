package com.example.littlelemoncompose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.littlelemoncompose.components.MyBottomNavbar

@Composable
fun OrderDishDetails(navController: NavHostController) {
    Scaffold(topBar = { com.example.littlelemoncompose.components.TopAppBar() }, bottomBar = {
        MyBottomNavbar(navController = navController)
    }, modifier = Modifier.systemBarsPadding()) { it ->
        Column(modifier = Modifier.padding(it)) {}
    }
}

@Preview(showBackground = true)
@Composable
fun OrderDishDetailsPreview() {
    //OrderDishDetails(null)
}