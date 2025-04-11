package com.example.littlelemoncompose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.littlelemoncompose.navigation.DrawerPanel
import com.example.littlelemoncompose.composables.homepage.LowerPanel
import com.example.littlelemoncompose.navigation.TopAppBar
import com.example.littlelemoncompose.composables.homepage.UpperPanel
import com.example.littlelemoncompose.navigation.MyBottomNavbar
import kotlinx.coroutines.launch

@Composable
fun HomePage(username: String?, navController: NavHostController) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            DrawerPanel { scope.launch { drawerState.close() } }
        },
    ) {
        Scaffold(topBar = {
            TopAppBar(drawerState, scope)
        }, bottomBar = {
            MyBottomNavbar(navController = navController)
        }, modifier = Modifier.systemBarsPadding()) { it ->
            Column(modifier = Modifier.padding(it)) {
                UpperPanel()
                LowerPanel(navController = navController)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePagePreview() {
    //HomePage("", navController = NavHostController())
}