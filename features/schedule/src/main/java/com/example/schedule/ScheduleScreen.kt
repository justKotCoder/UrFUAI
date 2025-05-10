package com.coderkot.schedule.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ScheduleScreen(
    id: String,
    modifier: Modifier = Modifier
) {
    Scaffold { padding ->
        Text(
            text = "Здесь будет расписание (ID: $id)",
            modifier = modifier
                .padding(padding)
                .fillMaxSize()
        )
    }
}

@Preview
@Composable
fun ScheduleScreenPreview() {
    ScheduleScreen("123")
}