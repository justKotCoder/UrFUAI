package com.coderkot.chat.data.remote.dtos.req

import com.squareup.moshi.Json

data class ChatModelRequestDto(
    @field:Json("max_tokens") val maxTokens: Int,
    @field:Json("messages") val messages: List<MessageDto>,
    @field:Json("model") val model: String,
    @field:Json("temperature") val temperature: Double
)