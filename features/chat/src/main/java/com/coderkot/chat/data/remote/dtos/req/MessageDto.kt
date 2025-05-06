package com.coderkot.chat.data.remote.dtos.req

import com.squareup.moshi.Json

data class MessageDto(
    @field:Json(name = "content") val content: String,
    @field:Json(name = "role") val role: String
)