package com.coderkot.home.data
import com.coderkot.home.domain.model.HomeItem
import com.coderkot.home.domain.repository.HomeRepository

// features/home/data/HomeRepositoryImpl.kt


class HomeRepositoryImpl : HomeRepository {
    override suspend fun getHomeItems(): List<HomeItem> {
        return listOf(
            HomeItem.Schedule(
                id = "1",
                time = "12:00-13:30",
                subject = "Алгоритмы и анализ сложности",
                type = "Лабораторные занятия",
                location = "Р247 Мира, 32",
                teacher = "Ульянова Ольга Семёновна",
                pairNumber = "1",
                groupInfo = "1"),
            HomeItem.News(
                id = "2",
                title = "Получение второго образования",
                content = "Параллельно с первым",
                date = "02.04.2025"
            ),
            HomeItem.ChatBot(
                title = "Чат-Бот"
            ),
            HomeItem.BRS(
                title = "БРС"
            ),
            HomeItem.Settings(
                title = "Настройки"
            )
        )
    }
}