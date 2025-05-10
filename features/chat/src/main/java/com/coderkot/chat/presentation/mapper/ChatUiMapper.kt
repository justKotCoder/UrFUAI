package com.coderkot.chat.presentation.mapper

import com.coderkot.chat.domain.model.ChatMessage
import com.coderkot.chat.presentation.ChatMessageUi

fun ChatMessage.toUI() = ChatMessageUi(role, content, isLoading)
fun ChatMessageUi.toDomain() = ChatMessage(role, content, isLoading = isLoading)
