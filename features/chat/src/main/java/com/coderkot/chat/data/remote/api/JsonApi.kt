package com.coderkot.chat.data.remote.api


import com.squareup.moshi.JsonClass
import retrofit2.http.GET

@JsonClass(generateAdapter = true)
data class JsonResponse(
    val status: String,
    val message: String,
    val timestamp: String,
    val data: List<JsonEntryDto>
)

@JsonClass(generateAdapter = true)
data class JsonEntryDto(
    val id: Int,
    val date: String,
    val group: String,
    val question: String,
    val text: String
)

interface JsonApi {
    @GET("/api.php?action=load")
    suspend fun loadData(): JsonResponse
}
