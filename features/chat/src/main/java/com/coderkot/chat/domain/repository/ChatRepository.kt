package com.coderkot.chat.domain.repository

import com.coderkot.chat.domain.model.DeepSeek
import com.coderkot.utils.ApiState

interface ChatRepository {
    suspend fun getResponse(prompt: String): ApiState<DeepSeek>
}