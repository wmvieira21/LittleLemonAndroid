package com.example.littlelemoncompose.screens

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.littlelemoncompose.Home
import com.example.littlelemoncompose.R
import com.example.littlelemoncompose.ui.theme.LittleLemonColors
import com.example.littlelemoncompose.ui.theme.LittleLemonComposeTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LoginScreen(navHostController: NavHostController, modifier: Modifier = Modifier) {
    //val context = LocalContext.current
    var normalClicks by rememberSaveable { mutableIntStateOf(0) }
    var longClicks by rememberSaveable { mutableIntStateOf(0) }
    var username by rememberSaveable { mutableStateOf("admin") }
    var password by rememberSaveable { mutableStateOf("admin") }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .closeKeyboardOnTap(),
    ) {
        Image(
            painter = painterResource(R.drawable.littlelemonimgtxt_nobg),
            contentDescription = "Logo image",
            contentScale = ContentScale.Fit,
            modifier = modifier
                .width(250.dp)
                .height(250.dp)
        )
        TextField(username,
            onValueChange = { s: String -> username = s },
            label = { Text(text = "username") })
        TextField(password,
            onValueChange = { s: String -> password = s },
            visualTransformation = PasswordVisualTransformation(),
            label = { Text(text = "password") })

        Button(
            onClick = {
                navHostController.navigate(Home.route + "/${username}")
                //Toast.makeText(context, "Tks for logging in!", Toast.LENGTH_SHORT).show()
            }, colors = ButtonDefaults.buttonColors(LittleLemonColors.green)
        ) {
            Text(text = "Login", color = Color(0xFFEDEFEE))
        }

        // content that you want to make clickable
        Text(
            text = "Normal: $normalClicks Long: $longClicks",
            color = Color.White,
            modifier = Modifier
                .background(LittleLemonColors.green)
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
                imageVector = Icons.Default.FavoriteBorder, contentDescription = ""
            )
        }
    }
}

fun Modifier.closeKeyboardOnTap(): Modifier = composed {
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    this.then(Modifier.clickable(
        interactionSource = remember { MutableInteractionSource() }, indication = null
    ) {
        focusManager.clearFocus()
        keyboardController?.hide()
    })
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LittleLemonComposeTheme {
        //LoginScreen(null)
    }
}