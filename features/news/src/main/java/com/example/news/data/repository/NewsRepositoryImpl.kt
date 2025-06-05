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
        val date = try {
            LocalDate.parse(
                this.date.substring(0, 10),
                DateTimeFormatter.ISO_LOCAL_DATE
            )
        } catch (e: Exception) {
            LocalDate.now()
        }

        return News(
            id = id,
            date = date,
            title = text.take(50) + if (text.length > 50) "..." else "",
            content = text,
            imageUrl = imageUrl
        )
    }
}