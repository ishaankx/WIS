package com.example.wis.ui.theme.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.wis.ui.theme.BLUE

@Composable
fun HeaderText(
    text:String,
    modifier: Modifier = Modifier
){
    Text(
        text = text,
        style = MaterialTheme.typography.displayMedium.copy(color = BLUE),
        fontWeight = FontWeight.ExtraLight,
        modifier = modifier
    )
}