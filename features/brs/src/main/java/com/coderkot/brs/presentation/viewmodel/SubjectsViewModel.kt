package com.coderkot.brs.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coderkot.brs.domain.model.Subject
import com.coderkot.brs.domain.usecases.GetSubjects
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
class SubjectsViewModel(
    private val getSubjects: GetSubjects
) : ViewModel() {
    private val _subjects = MutableStateFlow<List<Subject>>(emptyList())
    val subjects: StateFlow<List<Subject>> = _subjects.asStateFlow()

    private val _expandedSubjectIds = MutableStateFlow<Set<Int>>(emptySet())
    val expandedSubjectIds: StateFlow<Set<Int>> = _expandedSubjectIds.asStateFlow()

    init {
        viewModelScope.launch {
            _subjects.value = getSubjects()
        }
    }

    fun toggleExpanded(subjectId: Int) {
        _expandedSubjectIds.update { currentIds ->
            if (currentIds.contains(subjectId)) {
                currentIds - subjectId
            } else {
                currentIds + subjectId
            }
        }
    }
}