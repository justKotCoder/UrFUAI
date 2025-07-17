package com.example.schedule.data.model
import kotlinx.serialization.Serializable

@Serializable
data class ScheduleDto(
    val id: String,
    val title: String,
    val type: String,
    val time: String,
    val isPast: Boolean,
    val isCurrent: Boolean,
    val details: List<DetailDto>
)
