package com.coderkot.home.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.coderkot.home.domain.model.HomeItem
import com.coderkot.home.presentation.components.ChatBotCard
import com.coderkot.home.presentation.components.NewsCard
import com.coderkot.home.presentation.components.ScheduleCard
import com.coderkot.home.presentation.components.SettingsCard
import com.coderkot.home.presentation.components.TutorCard

@Composable
fun HomeScreen(
    onScheduleClick: () -> Unit,
    onNewsClick: () -> Unit,
    onChatClick: () -> Unit,
    onTutorClick: () -> Unit,
    onSettingsClick: () -> Unit
) {
    val mockItems = listOf(
        HomeItem.Schedule(
            id = "12:00-13:30",
            time = "12:00-13:30",
            subject = "Алгоритмы и анализ сложности",
            type = "Лабораторные занятия",
            location = "Р247 Мира, 32",
            teacher = "Ульянова Ольга Семёновна",
            pairNumber = "4 пара",
            groupInfo = "Алгоритмы и анализ сложности ЛБ, К, АТ-05"
        ),
        HomeItem.Chat("Чат-Бот"),
        HomeItem.News(
            id = "1",
            title = "Получение второго образования",
            date = "02.04.2025",
            content = "Параллельно с первым"
        ),
        HomeItem.Tutor("Тьютор"),
        HomeItem.Settings("Настройки")
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(mockItems) { item ->
            when (item) {
                is HomeItem.Schedule -> ScheduleCard(
                    item = item,
                    onClick = onScheduleClick
                )
                is HomeItem.News -> NewsCard(
                    onClick = onNewsClick
                )
                is HomeItem.Chat -> ChatBotCard(
                    onClick = onChatClick
                )
                is HomeItem.Tutor -> TutorCard(
                    onClick = onTutorClick
                )
                is HomeItem.Settings -> SettingsCard(
                    onClick = onSettingsClick
                )
            }
        }
    }
}