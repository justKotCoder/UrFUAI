package com.example.news.data.model

data class NewsDto(
    val id: Int,
    val date: String,
    val group: String,
    val zagolovok: String,
    val text: String,
    val imageUrl: String? = null
)