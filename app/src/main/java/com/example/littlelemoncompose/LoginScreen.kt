package com.example.littlelemoncompose

import android.graphics.drawable.Icon
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.littlelemoncompose.ui.theme.LittleLemonComposeTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var normalClicks by rememberSaveable { mutableStateOf(0) }
    var longClicks by rememberSaveable { mutableStateOf(0) }
    var usarname by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Image(
            painter = painterResource(R.drawable.littlelemonlogo),
            contentDescription = "Logo image",
            contentScale = ContentScale.Fit,
            modifier = modifier
                .width(250.dp)
                .height(250.dp)
        )
        TextField(
            usarname,
            onValueChange = { s: String -> usarname = s },
            label = { Text(text = "username") })
        TextField("", onValueChange = {}, label = { Text(text = "password") })

        Button(
            onClick = {
                Toast.makeText(context, "Tks for logging in!", Toast.LENGTH_SHORT).show()
            }, colors = ButtonDefaults.buttonColors(Color(0xFF495E57))
        ) {
            Text(text = "Login", color = Color(0xFFEDEFEE))
        }

        // content that you want to make clickable
        Text(
            text = "Normal: $normalClicks Long: $longClicks",
            color = Color.White,
            modifier = Modifier
                .background(Color(0xFF495E57))
                .padding(4.dp)
                .combinedClickable(onClick = { normalClicks++ }, onLongClick = { longClicks++ })
        )

        val state = rememberDraggableState { }
        Box(
            modifier = Modifier.draggable(state = state,
                orientation = androidx.compose.foundation.gestures.Orientation.Vertical,
                onDragStarted = { Log.d("Box", "Starting Drag") },
                onDragStopped = { Log.d("Box", "Finishing Drag") })
        ) {
            Image(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = ""
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LittleLemonComposeTheme {
        LoginScreen()
    }
}