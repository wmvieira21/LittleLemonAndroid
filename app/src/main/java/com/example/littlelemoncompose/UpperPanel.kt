package com.example.littlelemoncompose

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemoncompose.ui.theme.LittleLemonComposeTheme

@Composable
fun UpperPanel(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF495E57))
            .padding(16.dp)
    ) {
        Text(
            text = stringResource(R.string.restaurant_name_text),
            color = Color(0xFFF4CE14),
            fontSize = 32.sp
        )
        Text(
            text = stringResource(R.string.restaurant_city_text),
            color = Color(0xFFFFFFFF),
            fontSize = 24.sp
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.restaurant_desc_text),
                color = Color.White,
                fontSize = 20.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .width(200.dp)
                    .padding(top = 16.dp)
            )
            Image(
                painter = painterResource(R.drawable._d3cce7a3104bf255ed0e69195e2a157338c1bff),
                contentDescription = "",
                modifier = Modifier
                    .height(250.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
        }
        Button(
            onClick = {
                Toast.makeText(
                    context, "Order received. Thank you!", Toast.LENGTH_LONG
                ).show()
            },
            //border = BorderStroke(color = Color.Cyan, width = 0.5.dp),
            shape = RoundedCornerShape(50.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFFF4CE14)),

            ) {
            Text(text = stringResource(R.string.order_button_text), color = Color.Black)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun UpperPanelPreview() {
    LittleLemonComposeTheme {
        UpperPanel()
    }
}