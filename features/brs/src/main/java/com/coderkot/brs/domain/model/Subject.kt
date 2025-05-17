package com.coderkot.brs.domain.model

data class Subject(
    val id: Int,
    val name: String,
    val score: Double,
    val details: SubjectDetails? = null
)

data class SubjectDetails(
    val summary: String,
    val lecturesScore: Double,
    val labsScore: Double
)