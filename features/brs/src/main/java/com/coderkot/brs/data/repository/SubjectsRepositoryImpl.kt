package com.coderkot.brs.data.repository

import com.coderkot.brs.domain.model.Subject
import com.coderkot.brs.domain.model.SubjectDetails
import com.coderkot.brs.domain.repository.SubjectsRepository
class SubjectsRepositoryImpl : SubjectsRepository {
    override suspend fun getSubjects(): List<Subject> {
        return listOf(
            Subject(
                id = 1,
                name = "Базы данных и SQL",
                score = 86.00,
                details = SubjectDetails(
                    summary = "Отлично / 86.00 баллов",
                    lecturesScore = 41.00,
                    labsScore = 41.00
                )
            ),
            Subject(
                id = 2,
                name = "Алгоритмы и структуры данных",
                score = 72.50,
                details = SubjectDetails(
                    summary = "Хорошо / 72.50 баллов",
                    lecturesScore = 35.00,
                    labsScore = 37.50
                )
            ),
            Subject(
                id = 3,
                name = "Математический анализ",
                score = 95.00,
                details = SubjectDetails(
                    summary = "Отлично / 95.00 баллов",
                    lecturesScore = 50.00,
                    labsScore = 45.00
                )
            ),
            Subject(
                id = 4,
                name = "Иностранный язык",
                score = 68.30,
                details = SubjectDetails(
                    summary = "Удовлетворительно / 68.30 баллов",
                    lecturesScore = 30.00,
                    labsScore = 38.30
                )
            ),
            Subject(
                id = 5,
                name = "Теория вероятностей",
                score = 89.75,
                details = SubjectDetails(
                    summary = "Отлично / 89.75 баллов",
                    lecturesScore = 44.75,
                    labsScore = 45.00
                )
            ),
            Subject(
                id = 6,
                name = "Физика",
                score = 77.80,
                details = SubjectDetails(
                    summary = "Хорошо / 77.80 баллов",
                    lecturesScore = 37.80,
                    labsScore = 40.00
                )
            ),
            Subject(
                id = 7,
                name = "Программирование на Python",
                score = 91.20,
                details = SubjectDetails(
                    summary = "Отлично / 91.20 баллов",
                    lecturesScore = 41.20,
                    labsScore = 50.00
                )
            ),
            Subject(
                id = 8,
                name = "История",
                score = 63.40,
                details = SubjectDetails(
                    summary = "Удовлетворительно / 63.40 баллов",
                    lecturesScore = 33.40,
                    labsScore = 30.00
                )
            ),
            Subject(
                id = 9,
                name = "Дискретная математика",
                score = 84.60,
                details = SubjectDetails(
                    summary = "Отлично / 84.60 баллов",
                    lecturesScore = 44.60,
                    labsScore = 40.00
                )
            ),
            Subject(
                id = 10,
                name = "Компьютерные сети",
                score = 79.90,
                details = SubjectDetails(
                    summary = "Хорошо / 79.90 баллов",
                    lecturesScore = 39.90,
                    labsScore = 40.00
                )
            )
        )
    }
}