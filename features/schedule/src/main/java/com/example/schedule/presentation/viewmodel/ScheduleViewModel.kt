package com.example.schedule.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.schedule.domain.usecase.GetScheduleUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class ScheduleViewModel(
    private val getScheduleUseCase: GetScheduleUseCase
) : ViewModel() {
    private val _state = MutableStateFlow<ScheduleState>(ScheduleState.Loading)
    val state: StateFlow<ScheduleState> = _state

    fun loadSchedule(scheduleId: String) {
        viewModelScope.launch {
            _state.value = ScheduleState.Loading
            try {
                val schedule = getScheduleUseCase("1")
                _state.value = ScheduleState.Success(schedule)
            } catch (e: Exception) {
                _state.value = ScheduleState.Error(e.message ?: "Ошибка загрузки")
            }
        }
    }
}