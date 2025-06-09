package com.coderkot.chat.domain.usecases

import com.coderkot.chat.domain.model.JsonEntry
import com.coderkot.chat.domain.repository.JsonRepository

class FindAnswerInJsonUseCase(private val repository: JsonRepository) {
    suspend operator fun invoke(prompt: String): JsonEntry? = repository.findAnswer(prompt)
}