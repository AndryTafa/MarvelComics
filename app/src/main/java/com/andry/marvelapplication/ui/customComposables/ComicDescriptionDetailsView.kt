package com.andry.marvelapplication.ui.customComposables

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andry.marvelapplication.data.models.Comic

@Composable
fun ComicDescriptionDetailsView(comic: Comic?, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 10.dp)
    ) {
        comic?.let {
            it.description?.let { it1 ->
                Text(
                    modifier = modifier
                        .padding(10.dp),
                    text = it1,
                    style = TextStyle(
                        color = if (isSystemInDarkTheme()) MaterialTheme.colors.onPrimary else MaterialTheme.colors.onBackground,
                        fontSize = 20.sp,
                    ),
                )
            }
        }
    }
}