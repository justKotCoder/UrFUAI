package com.coderkot.chat.domain.model

data class JsonEntry(
    val id: Int,
    val date: String,
    val group: String,
    val question: String,
    val text: String
)