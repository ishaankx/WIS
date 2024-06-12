package com.example.wis.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.wis.R

val PromptFontFamily = FontFamily(
    Font(R.font.prompt_extralight, FontWeight.ExtraLight),
    Font(R.font.prompt_light, FontWeight.Light)
)

// Define typography
val PromptTypography = Typography(
    displayMedium = TextStyle(
        fontFamily = PromptFontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 42.sp),
    // Add other text styles as needed
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp)


// Set of Material typography styles to start with


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