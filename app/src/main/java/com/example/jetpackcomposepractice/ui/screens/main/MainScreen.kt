package com.example.jetpackcomposepractice.ui.screens.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.jetpackcomposepractice.model.MediaItem
import com.example.jetpackcomposepractice.ui.MyPracticeApp

@Composable
fun MainScreen(
    onMediaClick: (MediaItem) -> Unit
) {
    MyPracticeApp {
        Scaffold(
            topBar = { MainAppBar() }
        ) { padding ->
            MediaList(
                modifier = Modifier.padding(padding),
                onMediaClick = onMediaClick
            )
        }
    }
}