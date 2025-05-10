package com.example.news


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NewsScreen(
    id: String,
    modifier: Modifier = Modifier
) {
    Scaffold { padding ->
        Text(
            text = "Здесь будет новость (ID: $id)",
            modifier = modifier
                .padding(padding)
                .fillMaxSize()
        )
    }
}