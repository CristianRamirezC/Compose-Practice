package com.example.jetpackcomposepractice.ui.screens.detail

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.jetpackcomposepractice.model.getMedia
import com.example.jetpackcomposepractice.ui.screens.common.Thumb
import com.example.jetpackcomposepractice.ui.screens.shared.ArrowBackIcon


@Composable
fun DetailScreen(
    mediaId: Int,
    onUpClick: () -> Unit
) {
    val mediaItem = remember {
        getMedia().first { it.id == mediaId }
    }
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = mediaItem.title) },
                navigationIcon = { ArrowBackIcon(onUpClick) }
            )
        }
    ) { padding ->
        Thumb(
            mediaItem = mediaItem,
            modifier = Modifier.padding(padding)
        )
    }
}

