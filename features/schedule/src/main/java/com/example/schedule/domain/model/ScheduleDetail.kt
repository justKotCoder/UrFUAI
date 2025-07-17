package com.example.schedule.domain.model

import com.example.schedule.R


enum class IconType(val iconRes: Int) {
    TEACHER(R.drawable.home_profile),
    LOCATION(R.drawable.home_geo),
    GROUP(R.drawable.home_group)
}

data class ScheduleDetail(
    val title: String,
    val value: String,
    val iconType: IconType,
    val isCompleted: Boolean
)