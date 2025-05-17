package com.coderkot.brs.domain.usecases

import com.coderkot.brs.domain.model.Subject
import com.coderkot.brs.domain.repository.SubjectsRepository

class GetSubjects(
    private val repository: SubjectsRepository
) {
    suspend operator fun invoke(): List<Subject> {
        return repository.getSubjects()
    }
}