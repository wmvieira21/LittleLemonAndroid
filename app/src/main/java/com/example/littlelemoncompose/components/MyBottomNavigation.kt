package com.example.littlelemoncompose.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.littlelemoncompose.Destination
import com.example.littlelemoncompose.Home
import com.example.littlelemoncompose.Login
import com.example.littlelemoncompose.OrderDishDetail

@Composable
fun MyBottomNavbar(navController: NavHostController) {

    var selectedIndex by rememberSaveable {
        mutableStateOf(0)
    }

    val destinationsList = listOf<Destination>(
        Home, Login, OrderDishDetail
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    LaunchedEffect(currentRoute) {
        val newIndex = destinationsList.indexOfFirst { it.route == currentRoute }
        if (newIndex != -1) {
            selectedIndex = newIndex
            println("✅ Route changed to $currentRoute, selectedIndex updated to $newIndex")
        }
    }

    NavigationBar {
        destinationsList.forEachIndexed { index, navigationItem ->
            NavigationBarItem(
                label = { Text(text = navigationItem.tittle) },
                icon = { Icon(imageVector = navigationItem.icon, contentDescription = "") },
                onClick = {
                    selectedIndex = index
                    navController.navigate(navigationItem.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                    }
                },
                selected = index == selectedIndex
            )
        }
    }
}