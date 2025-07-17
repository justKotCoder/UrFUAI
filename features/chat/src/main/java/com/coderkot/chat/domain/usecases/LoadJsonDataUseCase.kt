package com.coderkot.chat.domain.usecases

import com.coderkot.chat.domain.repository.JsonRepository

class LoadJsonDataUseCase(private val repository: JsonRepository) {
    suspend operator fun invoke() = repository.loadData()
}