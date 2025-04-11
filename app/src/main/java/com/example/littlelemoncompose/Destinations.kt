package com.example.littlelemoncompose

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

interface Destinations {
    val route: String
    val tittle: String
    val icon: ImageVector
}

object Home : Destinations {
    const val USERNAME = "TeamViewer"
    override val route: String = "HOME"
    override val icon: ImageVector = Icons.Filled.Home
    override val tittle: String = "Home"
}

object Login : Destinations {
    override val route: String = "LOGIN"
    override val icon: ImageVector = Icons.Filled.Settings
    override val tittle: String = "Login"
}

object DishDetails : Destinations {
    const val argDishId = "argDishId"
    override val route = "MENU"
    override val tittle = "Menu"
    override val icon: ImageVector = Icons.Filled.ShoppingCart
}

