package com.example.news.domain.model

import org.threeten.bp.LocalDate

data class News(
    val id: Int,
    val date: LocalDate,
    val title: String,
    val content: String,
    val imageUrl: String?
)