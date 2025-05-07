import com.coderkot.home.domain.model.HomeItem
import com.coderkot.home.domain.repository.HomeRepository

// features/home/data/HomeRepositoryImpl.kt
class HomeRepositoryImpl : HomeRepository {
    override suspend fun getHomeItems(): List<HomeItem> {
        return listOf(
            HomeItem.Schedule(
                id = 1,
                time = "12:00-13:30",
                subject = "Алгоритмы и анализ сложности",
                type = "Лабораторные занятия",
                location = "P247 Мира, 32",
                teacher = "Ульянова Ольга Семёновна",
                isCompleted = true
            ),
            HomeItem.News(
                id = 2,
                title = "Получение второго образования",
                content = "Параллельно с первым",
                date = "02.04.2025"
            ),
            HomeItem.ChatBot,
            HomeItem.BRS,
            HomeItem.Settings
        )
    }
}