// features/home/domain/model/HomeItem.kt
package com.coderkot.home.domain.model

sealed class HomeItem {
    data class Schedule(
        val id: String,
        val time: String,
        val subject: String,
        val type: String,
        val location: String,
        val teacher: String,
        val pairNumber: String?, // Make nullable if optional
        val groupInfo: String? // Make nullable if optional
    ) : HomeItem()

    data class News(
        val id: String,
        val title: String,
        val content: String,
        val date: String
    ) : HomeItem()

    data class Chat(val title: String) : HomeItem()
    data class Settings(val title: String) : HomeItem()
    data class Tutor(val title: String) : HomeItem()
}