package com.coderkot.chat.domain.repository

import com.coderkot.chat.domain.model.JsonEntry

interface JsonRepository {
    suspend fun loadData()
    suspend fun findAnswer(prompt: String): JsonEntry?
}