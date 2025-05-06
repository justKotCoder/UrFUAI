package com.coderkot.chat.domain.model

data class DeepSeek(
    val choices: List<Choice>,
    val created: Int,
    val id: String,
    val model: String,
    val deepObject: String,
    val systemFingerprint: String,
    val usage: Usage
)
