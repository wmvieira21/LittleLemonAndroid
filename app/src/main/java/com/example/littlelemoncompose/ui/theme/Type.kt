package com.example.littlelemoncompose.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(

    headlineLarge = TextStyle(
        fontSize = 26.sp, fontWeight = FontWeight.Bold, color = LittleLemonColors.charcoal
    ), headlineMedium = TextStyle(
        color = LittleLemonColors.cloud, fontSize = 18.sp, fontWeight = FontWeight.Bold
    ), headlineSmall = TextStyle(
        color = LittleLemonColors.cloud, fontSize = 16.sp, fontWeight = FontWeight.Bold,
    ), bodyLarge = TextStyle(
        color = LittleLemonColors.black,
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold
    ), bodyMedium = TextStyle(
        color = LittleLemonColors.green,
        fontSize = 16.sp
    ), bodySmall = TextStyle(
        color = LittleLemonColors.cloud, fontSize = 16.sp
    ), labelSmall = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold
    )

    /* Other default text styles to override
        titleLarge = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 22.sp,
            lineHeight = 28.sp,
            letterSpacing = 0.sp
        ),
        labelSmall = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Medium,
            fontSize = 11.sp,
            lineHeight = 16.sp,
            letterSpacing = 0.5.sp
        )
        */

)

