package com.example.schedule.presentation.viewmodel

import com.example.schedule.domain.model.Schedule

sealed class ScheduleState {
    object Loading : ScheduleState()
    data class Success(val schedule: Schedule) : ScheduleState()
    data class Error(val message: String) : ScheduleState()
}
