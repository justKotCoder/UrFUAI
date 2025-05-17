package com.example.schedule.data.mapper

import com.example.schedule.data.model.DetailDto
import com.example.schedule.data.model.ScheduleDto
import com.example.schedule.domain.model.IconType
import com.example.schedule.domain.model.Schedule
import com.example.schedule.domain.model.ScheduleDetail


fun ScheduleDto.toDomain(): Schedule {
    val teacher = details.getOrNull(0)?.text ?: "Преподаватель"
    val location = details.getOrNull(1)?.text ?: "Аудитория"
    val groupInfo = details.getOrNull(2)?.text ?: "Группа"
    val pairNumber = "1" // можно заменить, если появится поле

    return Schedule(
        id = id,
        time = time,
        type = type,
        subject = title,
        teacher = teacher,
        location = location,
        groupInfo = groupInfo,
        pairNumber = pairNumber,
        isCompleted = isPast,
        isCurrent = isCurrent,
        details = listOfNotNull(
            details.getOrNull(0)?.toDomain("Преподаватель", IconType.TEACHER),
            details.getOrNull(1)?.toDomain("Аудитория", IconType.LOCATION),
            details.getOrNull(2)?.toDomain("Группа", IconType.GROUP)
        )
    )
}


fun DetailDto.toDomain(title: String, iconType: IconType): ScheduleDetail {
    return ScheduleDetail(
        title = title,
        value = text,
        iconType = iconType,
        isCompleted = false
    )
}
