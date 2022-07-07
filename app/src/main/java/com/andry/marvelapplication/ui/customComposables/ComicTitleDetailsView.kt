package com.andry.marvelapplication.ui.customComposables

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.andry.marvelapplication.data.models.Comic

@Composable
fun ComicTitleDetailsView(comic: Comic?, modifier: Modifier = Modifier) {
    comic?.let { HeaderComicText(title = it.title, modifier = modifier.padding(20.dp)) }
}