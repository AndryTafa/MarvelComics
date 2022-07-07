package com.andry.marvelapplication.ui.customComposables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.andry.marvelapplication.R

@Composable
fun ThumbnailImageListView(thumbnailUrl: String) {
    Image(
        painter = rememberAsyncImagePainter(
            thumbnailUrl,
            placeholder = painterResource(id = R.drawable.loading_image),
            error = painterResource(id = R.drawable.no_internet_default_image)
        ),
        contentDescription = "Comic cover image",
        modifier = Modifier
            .size(190.dp),
        contentScale = ContentScale.FillHeight,
    )
}