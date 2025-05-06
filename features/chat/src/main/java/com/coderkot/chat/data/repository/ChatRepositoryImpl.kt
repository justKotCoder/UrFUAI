package com.coderkot.chat.data.repository

import com.coderkot.chat.data.mapper.toDeepSeek
import com.coderkot.chat.data.remote.api.ChatService
import com.coderkot.chat.data.remote.dtos.req.ChatModelRequestDto
import com.coderkot.chat.data.remote.dtos.req.MessageDto
import com.coderkot.chat.domain.model.DeepSeek
import com.coderkot.chat.domain.repository.ChatRepository
import com.coderkot.utils.ApiState

class ChatRepositoryImpl(
    private val chatService: ChatService
): ChatRepository {
    override suspend fun getResponse(prompt: String): ApiState<DeepSeek> {
        return try {
            ApiState.Success(chatService.getChatCompletion(
                "Bearer sk-17712353c6384206ba223c56b3ae2ed2",
                ChatModelRequestDto(
                    maxTokens = 1500,
                    messages = listOf(MessageDto(
                        prompt,
                        role = "user"
                    ),
                        MessageDto(
                            prompt,
                            role = "system"
                        )),
                    model = "deepseek-chat",
                    temperature = 0.7
                )
            ).toDeepSeek())
        } catch (e: Exception) {
            ApiState.Error(e.message)
        }
    }
}