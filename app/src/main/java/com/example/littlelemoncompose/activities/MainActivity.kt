package com.example.littlelemoncompose.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.littlelemoncompose.DishDetails
import com.example.littlelemoncompose.Home
import com.example.littlelemoncompose.Login
import com.example.littlelemoncompose.screens.DishDetails
import com.example.littlelemoncompose.screens.HomePage
import com.example.littlelemoncompose.screens.LoginScreen
import com.example.littlelemoncompose.ui.theme.LittleLemonComposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LittleLemonComposeTheme {
                MyNavigation()
            }
        }
    }
}

@Composable
fun MyNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Login.route) {
        composable(Login.route) {
            LoginScreen(navController)
        }

        composable(
            Home.route + "/{${Home.USERNAME}}", arguments = listOf(navArgument(Home.USERNAME) {
                type = NavType.StringType
            })
        ) {
            HomePage(it.arguments?.getString(Home.USERNAME), navController)
        }

        composable(
            DishDetails.route + "/{${DishDetails.argDishId}}",
            arguments = listOf(navArgument(DishDetails.argDishId) {
                type = NavType.StringType
            })
        ) {
            DishDetails(it.arguments?.getString(DishDetails.argDishId), navController)
        }
    }
}

