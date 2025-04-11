package com.example.littlelemoncompose.composables.homepage

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemoncompose.R
import com.example.littlelemoncompose.ui.theme.LittleLemonColors
import com.example.littlelemoncompose.ui.theme.LittleLemonComposeTheme
import com.example.littlelemoncompose.ui.theme.Shapes

@Composable
fun UpperPanel() {
    val context = LocalContext.current
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .background(LittleLemonColors.green)
            .padding(start = 12.dp, end = 12.dp, top = 16.dp, bottom = 16.dp)
    ) {
        Text(
            text = stringResource(R.string.restaurant_name_text),
            color = LittleLemonColors.yellow,
            fontSize = 40.sp
        )
        Text(
            text = stringResource(R.string.restaurant_city_text),
            style = MaterialTheme.typography.bodySmall,
            fontSize = 24.sp,
            modifier = Modifier.padding(top = 8.dp)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
        ) {
            Text(
                text = stringResource(R.string.description),
                style = MaterialTheme.typography.bodySmall,
                /*fontSize = 20.sp,
                textAlign = TextAlign.Start,*/
                modifier = Modifier
                    .padding(bottom = 28.dp, end = 20.dp)
                    .fillMaxWidth(0.6f)
            )
            Image(
                painter = painterResource(R.drawable.upperpanelimage),
                contentDescription = "Upper Panel Image",
                modifier = Modifier.clip(RoundedCornerShape(10.dp))
            )
        }
        Button(
            onClick = {
                Toast.makeText(
                    context, "Order received. Thank you!", Toast.LENGTH_LONG
                ).show()
            },
            shape = Shapes.small,
            //border = BorderStroke(color = Color.Cyan, width = 0.5.dp),
            //colors = ButtonDefaults.buttonColors(Color(0xFFF4CE14)),

        ) {
            Text(
                text = stringResource(R.string.order_button_text),
                style = MaterialTheme.typography.labelSmall,
                color = LittleLemonColors.green
            )
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