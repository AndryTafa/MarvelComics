package com.andry.marvelapplication.ui.customComposables

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

@Composable
fun ExtraInfoText(string: String) {
    DescriptionComicText(
        string = string,
        maxLines = 2,
        fontSize = 17.sp,
        alignCenter = true
    )
}