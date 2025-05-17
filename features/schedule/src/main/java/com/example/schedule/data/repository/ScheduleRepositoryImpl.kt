package com.example.schedule.data.repository

import com.example.schedule.R
import com.example.schedule.data.model.DetailDto
import com.example.schedule.data.model.ScheduleDto
import com.example.schedule.data.mapper.toDomain
import com.example.schedule.domain.model.Schedule
import com.example.schedule.domain.repository.ScheduleRepository

class ScheduleRepositoryImpl : ScheduleRepository {

    override suspend fun getScheduleById(id: String): Schedule {
        val dto = mockData.find { it.id == id }
            ?: error("Schedule with id $id not found")
        return dto.toDomain()
    }


    override suspend fun getSchedule(): List<Schedule> {
        return mockData.map { it.toDomain() }
    }

    private val mockData = listOf(
        ScheduleDto(
            id = "1",
            time = "8:30 - 10:00",
            type = "Практическое занятие №9",
            title = "Прикладная физическая культура Часть 4",
            isPast = true,
            isCurrent = false,
            details = listOf(
                DetailDto("Николаев Анатолий Евгеньевич", R.drawable.home_profile),
                DetailDto("Стадион Мира, 9a", R.drawable.home_geo),
                DetailDto("ИКБО-01-22", R.drawable.home_group)
            )
        )
    )
}
