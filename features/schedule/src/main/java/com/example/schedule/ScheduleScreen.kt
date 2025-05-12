package com.coderkot.schedule.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun ScheduleScreen(onBackClick: () -> Unit) {
    // Содержимое экрана настроек
    Box(modifier = Modifier.padding(16.dp)) {
        Text("Экран расписания")
    }
}
