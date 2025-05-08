package com.coderkot.home.domain.model

// features/home/domain/model/HomeItem.kt
sealed class HomeItem {
    data class Schedule(
        val id: Int,
        val time: String,
        val subject: String,
        val type: String,
        val location: String,
        val teacher: String,
        val isCompleted: Boolean
    ) : HomeItem()

    data class News(
        val id: Int,
        val title: String,
        val content: String,
        val date: String
    ) : HomeItem()

    object ChatBot : HomeItem()
    object BRS : HomeItem()
    object Settings : HomeItem()
}