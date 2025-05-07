package com.coderkot.chat.domain.model

data class ChatMessage(
    val role: String,
    val content: String,
    val timestamp: Long = System.currentTimeMillis(),
    val isLoading: Boolean = false
)