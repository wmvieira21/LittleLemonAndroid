package com.example.littlelemoncompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.littlelemoncompose.ui.theme.LittleLemonComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            LittleLemonComposeTheme {
                HomePage()
            }
        }
    }

    @Composable
    fun HomePage(modifier: Modifier = Modifier) {
        Column {
            UpperPanel()
            LowerPanel()
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun HomePagePreview() {
        HomePage(modifier = Modifier)
    }
}

