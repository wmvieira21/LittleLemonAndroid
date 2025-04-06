package com.example.littlelemoncompose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.littlelemoncompose.components.DrawerPanel
import com.example.littlelemoncompose.components.LowerPanel
import com.example.littlelemoncompose.components.MyBottomNavbar
import com.example.littlelemoncompose.components.TopAppBar
import com.example.littlelemoncompose.components.UpperPanel
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
        }) { it ->
            Column(modifier = Modifier.padding(it)) {
                UpperPanel()
                LowerPanel()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePagePreview() {
    //HomePage("", navController = NavHostController())
}