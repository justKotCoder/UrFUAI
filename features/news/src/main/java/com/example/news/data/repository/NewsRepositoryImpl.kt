package com.example.news.data.repository

import com.example.news.data.api.NewsApiService
import com.example.news.data.api.LoginRequest
import com.example.news.data.model.NewsDto
import com.example.news.domain.model.News
import com.example.news.domain.repository.NewsRepository
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter

class NewsRepositoryImpl(
    private val apiService: NewsApiService
) : NewsRepository {
    private var authToken: String? = null

    override suspend fun authenticate() {
        val response = apiService.login(LoginRequest("gp-admin", "gp-admin"))
        if (response.isSuccessful) {
            authToken = response.body()?.token
        }
    }

    override suspend fun getNews(): List<News> {
        if (authToken == null) {
            authenticate()
        }

        return try {
            val response = apiService.getNews()
            if (response.isSuccessful) {
                response.body()?.data?.map { it.toDomain() } ?: emptyList()
            } else {
                emptyList()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }

    private fun NewsDto.toDomain(): News {
        val dateTime = try {
            org.threeten.bp.LocalDateTime.parse(
                this.date,
                DateTimeFormatter.ISO_DATE_TIME
            )
        } catch (e: Exception) {
            try {
                org.threeten.bp.LocalDate.parse(
                    this.date.substring(0, 10),
                    DateTimeFormatter.ISO_LOCAL_DATE
                ).atStartOfDay()
            } catch (e: Exception) {
                org.threeten.bp.LocalDateTime.now()
            }
        }

        return News(
            id = id,
            date = dateTime,
            title = zagolovok,
            content = text,
            imageUrl = imageUrl
        )
    }
}