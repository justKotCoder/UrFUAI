package com.example.news.data.api

import com.example.news.data.model.NewsDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface NewsApiService {
    @GET("api.php?action=loadNovosti")
    suspend fun getNews(): Response<NewsResponse>

    @POST("api.php?action=login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>
}

data class NewsResponse(
    val status: String,
    val message: String,
    val timestamp: String,
    val data: List<NewsDto>
)


data class LoginResponse(
    val status: String,
    val message: String,
    val timestamp: String,
    val token: String
)