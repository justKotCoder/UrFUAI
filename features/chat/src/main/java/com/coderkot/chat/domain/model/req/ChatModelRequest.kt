package com.coderkot.chat.domain.model.req

data class ChatModelRequest(
    val maxTokens: Int,
    val messages: List<Message>,
    val model: String,
    val temperature: Double
)