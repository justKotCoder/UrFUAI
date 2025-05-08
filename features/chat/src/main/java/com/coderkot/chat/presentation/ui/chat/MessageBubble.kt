package com.coderkot.chat.presentation.ui.chat

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.coderkot.chat.domain.model.ChatMessage

@Composable
fun MessageBubble(message: ChatMessage) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        if (message.role == "user") {
            UserMessage(message.content)
        } else {
            AssistantMessage(message)
        }
    }
}
