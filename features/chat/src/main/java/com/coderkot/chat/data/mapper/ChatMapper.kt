package com.coderkot.chat.data.mapper

import com.coderkot.chat.data.remote.dtos.DeepSeekDto
import com.coderkot.chat.data.remote.dtos.req.ChatModelRequestDto
import com.coderkot.chat.data.remote.dtos.req.MessageDto
import com.coderkot.chat.domain.model.DeepSeek
import com.coderkot.chat.domain.model.req.Message
import com.coderkot.chat.domain.model.req.ChatModelRequest

fun DeepSeekDto.toDeepSeek(): DeepSeek {
    return DeepSeek(
        choices = this.choices,
        created = this.created,
        id = this.id,
        model = this.model,
        deepObject = this.deepObject,
        systemFingerprint = this.systemFingerprint,
        usage = this.usage
    )
}


fun List<MessageDto>.toListMessage(): List<Message> {
    return this.map {
        Message(
            content = it.content,
            role = it.role
        )
    }
}

fun ChatModelRequestDto.toChatModelRequest(): ChatModelRequest {
    return ChatModelRequest(
        maxTokens = this.maxTokens,
        messages = this.messages.toListMessage(),
        model = this.model,
        temperature = this.temperature,
    )
}


