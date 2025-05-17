package com.example.schedule.data.model

import kotlinx.serialization.Serializable

@Serializable
data class DetailDto(
    val text: String,
    val iconResId: Int
)
