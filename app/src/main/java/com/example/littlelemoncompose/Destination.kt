package com.example.littlelemoncompose

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

interface Destination {
    val route: String
    val icon: ImageVector
    val tittle: String
}

object Home : Destination {
    const val USERNAME = "TeamViewer"
    override val route: String = "HOME"
    override val icon: ImageVector = Icons.Filled.Home
    override val tittle: String = "Home"
}

object Login : Destination {
    override val route: String = "LOGIN"
    override val icon: ImageVector = Icons.Filled.Settings
    override val tittle: String = "Login"
}

object OrderDishDetail : Destination {
    override val route: String = "ORDER"
    override val icon: ImageVector = Icons.Filled.ShoppingCart
    override val tittle: String = "Cart"
}
