package com.andry.marvelapplication.ui.customComposables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.andry.marvelapplication.data.models.Comic

@Composable
fun ExtraInfoRow(comic: Comic?, modifier: Modifier = Modifier) {
    Column() {
        Row(
            modifier = modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ExtraInfoText(string = "Pages: ${comic?.pageCount}")
            ExtraInfoText(string = "Format: ${comic?.format}")
        }
        Row(
            modifier = modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            ExtraInfoText(string = "Series: ${comic?.series?.name}")
        }
    }
}