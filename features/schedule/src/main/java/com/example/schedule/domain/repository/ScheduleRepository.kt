package com.example.schedule.domain.repository

import com.example.schedule.domain.model.Schedule

interface ScheduleRepository {
    suspend fun getScheduleById(id: String): Schedule
    suspend fun getSchedule(): List<Schedule>
}
