package com.example.news.domain.model

import org.threeten.bp.LocalDateTime

data class News(
    val id: Int,
    val date: LocalDateTime,
    val title: String,
    val content: String,
    val imageUrl: String?
)