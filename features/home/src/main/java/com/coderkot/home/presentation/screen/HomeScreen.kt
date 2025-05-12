package com.coderkot.home.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.coderkot.home.domain.model.HomeItem
import com.coderkot.home.presentation.components.BRSCard
import com.coderkot.home.presentation.components.ChatBotCard
import com.coderkot.home.presentation.components.NewsCard
import com.coderkot.home.presentation.components.ScheduleCard
import com.coderkot.home.presentation.components.SettingsCard

// features/home/presentation/screen/HomeScreen.kt
@Composable
fun HomeScreen(navController: NavController) {
    val mockItems = listOf(
        HomeItem.Schedule(
            time = "12:00-13:30",
            subject = "Алгоритмы и анализ сложности",
            type = "Лабораторные занятия",
            location = "Р247 Мира, 32",
            teacher = "Ульянова Ольга Семёновна",
            pairNumber = "4 пара",
            groupInfo = "Алгоритмы и анализ сложности ЛБ, К, АТ-05"
        ),
        HomeItem.ChatBot("Чат-Бот"),
        HomeItem.BRS("БРС"),
        HomeItem.News(
            id = "1",
            title = "Получение второго образования",
            date = "02.04.2025",
            content = "Параллельно с первым"
        ),
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
                    onClick = {
                        navController.navigate("schedule/${item.time}") {
                            popUpTo(navController.graph.startDestinationId) { saveState = true }
                            launchSingleTop = true
                        }
                    }
                )

                is HomeItem.News -> NewsCard(
                    onClick = {
                        navController.navigate("news/${item.id}") {
                            popUpTo(navController.graph.startDestinationId) { saveState = true }
                            launchSingleTop = true
                        }
                    }
                )

                is HomeItem.ChatBot -> ChatBotCard(
                    onClick = {
                        navController.navigate("chat") {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )

                is HomeItem.BRS -> BRSCard(
                    onClick = {
                        navController.navigate("brs") {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )

                is HomeItem.Settings -> SettingsCard(
                    onClick = {
                        navController.navigate("settings") {
                            popUpTo(navController.graph.startDestinationId) { saveState = true }
                            launchSingleTop = true
                        }
                    }
                )
            }
        }
    }
}