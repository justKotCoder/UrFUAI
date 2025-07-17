package com.coderkot.chat.data.repository

import com.coderkot.chat.data.mapper.toDomain
import com.coderkot.chat.data.remote.api.JsonApi
import com.coderkot.chat.domain.model.JsonEntry
import com.coderkot.chat.domain.repository.JsonRepository

class JsonRepositoryImpl(
    private val api: JsonApi
) : JsonRepository {

    private val cache = mutableListOf<JsonEntry>()

    override suspend fun loadData() {
        val response = api.loadData()
        if (response.status == "success") {
            cache.clear()
            cache.addAll(response.data.map { it.toDomain() })
        }
    }

    override suspend fun findAnswer(prompt: String): JsonEntry? {
        val normalizedPrompt = prompt.normalize()
        return cache.firstOrNull { entry ->
            entry.question.normalize() == normalizedPrompt
        }
    }

    private fun String.normalize(): String {
        return lowercase()
            .replace(Regex("[^а-яa-z0-9 ]"), "")
            .replace("\\s+".toRegex(), " ")
            .trim()
    }
}
