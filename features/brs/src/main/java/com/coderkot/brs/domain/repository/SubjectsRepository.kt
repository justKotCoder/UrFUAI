package com.coderkot.brs.domain.repository

import com.coderkot.brs.domain.model.Subject

interface SubjectsRepository {
    suspend fun getSubjects(): List<Subject>
}