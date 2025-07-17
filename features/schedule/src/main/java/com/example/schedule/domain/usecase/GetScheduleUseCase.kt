package com.example.schedule.domain.usecase

import com.example.schedule.domain.model.Schedule
import com.example.schedule.domain.repository.ScheduleRepository
import javax.inject.Inject

class GetScheduleUseCase @Inject constructor(
    private val repository: ScheduleRepository
) {
    suspend operator fun invoke(scheduleId: String): Schedule {
        return repository.getScheduleById(scheduleId)
    }
}