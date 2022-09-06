package com.example.jetpackcomposepractice.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.jetpackcomposepractice.ui.theme.JetPackComposePracticeTheme

@Composable
fun MyPracticeApp(content: @Composable () -> Unit) {
    JetPackComposePracticeTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            content()
        }
    }
}