package com.andry.marvelapplication.ui.customComposables

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun HeaderComicText(title: String, fontSize: TextUnit = 25.sp, modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        text = title,
        style = TextStyle(
            color = if (isSystemInDarkTheme()) MaterialTheme.colors.onPrimary else MaterialTheme.colors.onBackground,
            fontWeight = FontWeight.Bold,
            fontSize = fontSize
        )
    )
}