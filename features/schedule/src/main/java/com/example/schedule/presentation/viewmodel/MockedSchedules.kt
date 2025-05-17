package com.example.schedule.presentation.viewmodel

import com.example.schedule.domain.model.IconType
import com.example.schedule.domain.model.Schedule
import com.example.schedule.domain.model.ScheduleDetail


val mockedSchedules = listOf(
    Schedule(
        id = "1",
        time = "8:30 - 10:00",
        type = "Практическое занятие №9",
        subject = "Прикладная физическая культура Часть 4",
        teacher = "Николаев Анатолий Евгеньевич",
        location = "Стадион Мира, 9a",
        groupInfo = "ИКБО-01-22",
        pairNumber = "1",
        isCompleted = false,
        isCurrent = false,
        details = listOf(
            ScheduleDetail(
                "Преподаватель", "Николаев Анатолий Евгеньевич", IconType.TEACHER, false ),
            ScheduleDetail("Аудитория", "Стадион Мира, 9a", IconType.LOCATION, false),
            ScheduleDetail("Группа", "ИКБО-01-22",IconType.GROUP, false)
        )
    )
    // другие пары
)
