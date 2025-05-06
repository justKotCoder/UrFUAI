package com.coderkot.chat.data.remote.dtos

import com.coderkot.chat.domain.model.Choice
import com.coderkot.chat.domain.model.Usage
import com.squareup.moshi.Json

data class DeepSeekDto(
    @field:Json("choices") val choices: List<Choice>,
    @field:Json("created") val created: Int,
    @field:Json("id") val id: String,
    @field:Json("model") val model: String,
    @field:Json(name = "object") val deepObject: String,
    @field:Json("system_fingerprint") val systemFingerprint: String,
    @field:Json("usage") val usage: Usage
)