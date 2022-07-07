package com.andry.marvelapplication.ui.customComposables

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun DescriptionComicText(
    string: String,
    fontSize: TextUnit = 10.sp,
    modifier: Modifier = Modifier,
    maxLines: Int = 5,
    alignCenter: Boolean = false
) {
    Text(
        modifier = modifier,
        text = string,
        style = TextStyle(
            color = if (isSystemInDarkTheme()) MaterialTheme.colors.onPrimary else MaterialTheme.colors.onBackground,
            fontSize = fontSize,
        ),
        maxLines = maxLines,
        overflow = TextOverflow.Ellipsis,
        textAlign = if (alignCenter) TextAlign.Center else TextAlign.Justify

    )
}