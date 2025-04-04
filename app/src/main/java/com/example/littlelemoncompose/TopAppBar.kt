package com.example.littlelemoncompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.DrawerState
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun TopAppBar(drawerState: DrawerState? = null, scope: CoroutineScope? = null) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        IconButton(onClick = {
            scope?.launch { drawerState?.open() }
        }) {
            Image(
                imageVector = Icons.Default.Menu,
                contentDescription = "hamburger menu",
                modifier = Modifier.size(42.dp)
            )

        }
        Image(
            painter = painterResource(R.drawable.aa38384d3942a55696d8070552aed2f4c190fc14),
            contentDescription = "Little lemon logo",
            modifier = Modifier.padding(8.dp)

        )
        IconButton(onClick = {}) {
            Image(
                imageVector = Icons.Outlined.ShoppingCart,
                contentDescription = "hamburger menu",
                modifier = Modifier.size(42.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopAppBarPreveiw() {
    TopAppBar()
}
