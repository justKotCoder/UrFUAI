package com.coderkot.chat.data.remote.api

import com.coderkot.chat.data.remote.dtos.DeepSeekDto
import com.coderkot.chat.data.remote.dtos.req.ChatModelRequestDto
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ChatService {
    @POST("chat/completions")
    suspend fun getChatCompletion(
        @Header("Authorization") auth: String,
        @Body request: ChatModelRequestDto
    ): DeepSeekDto
}