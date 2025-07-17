package com.example.schedule.domain.model


data class Schedule(
    val id: String,
    val time: String,
    val type: String,
    val subject: String,
    val teacher: String,
    val location: String,
    val groupInfo: String,
    val pairNumber: String,
    val isCompleted: Boolean,
    val isCurrent: Boolean,
    val details: List<ScheduleDetail>
)