package com.coderkot.chat.presentation

import kotlinx.serialization.Serializable

@Serializable
data class ChatMessageUi(
    val role: String,
    val content: String,
    val isLoading: Boolean = false
)
