package com.coderkot.chat.domain.usecases

import com.coderkot.chat.domain.repository.ChatRepository

class GetResponseUseCase(
    private val repository: ChatRepository
) {
    suspend operator fun invoke(prompt: String) = repository.getResponse(prompt)
}