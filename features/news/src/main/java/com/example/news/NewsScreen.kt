package com.example.news


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun NewsScreen(onBackClick: () -> Unit) {
    // Содержимое экрана настроек
    Box(modifier = Modifier.padding(16.dp)) {
        Text("Экран настроек")
    }
}
