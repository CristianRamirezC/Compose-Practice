package com.example.jetpackcomposepractice.ui.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import com.example.jetpackcomposepractice.R
import com.example.jetpackcomposepractice.model.MediaItem
import com.example.jetpackcomposepractice.model.getMedia
import com.example.jetpackcomposepractice.ui.screens.common.Thumb

@Composable
fun MediaList(
    modifier: Modifier = Modifier,
    onMediaClick: (MediaItem) -> Unit
) {
    LazyVerticalGrid(
        contentPadding = PaddingValues(dimensionResource(R.dimen.padding_xsmall)),
        modifier = modifier
            .background(Color.White),
        columns = GridCells.Adaptive(dimensionResource(R.dimen.cell_min_width))
    ) {
        items(getMedia()) { item ->
            MediaListItem(
                mediaItem = item,
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_xsmall)),
                onClick = { onMediaClick(item) }
            )
        }
    }
}

@Composable
fun MediaListItem(
    mediaItem: MediaItem,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .clickable(onClick = onClick)
    ) {
        Thumb(mediaItem = mediaItem)
        Title(mediaItem = mediaItem)

    }
}

@Composable
fun Title(mediaItem: MediaItem) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.secondary)
            .padding(dimensionResource(R.dimen.padding_medium))
    ) {
        Text(
            text = mediaItem.title,
            style = MaterialTheme.typography.h6
        )
    }
}