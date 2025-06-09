package com.coderkot.chat.data.mapper

import com.coderkot.chat.data.remote.api.JsonEntryDto
import com.coderkot.chat.domain.model.JsonEntry


fun JsonEntryDto.toDomain(): JsonEntry =
    JsonEntry(id, date, group, question, text)
