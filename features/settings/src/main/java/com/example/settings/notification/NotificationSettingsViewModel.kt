package com.example.settings.notification

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NotificationSettingsViewModel : ViewModel() {
    private val _state = MutableStateFlow(NotificationSettingsState())
    val state = _state.asStateFlow()

    fun togglePushNotifications() {
        viewModelScope.launch {
            _state.emit(state.value.copy(pushNotificationsEnabled = !state.value.pushNotificationsEnabled))
        }
    }

    fun updateNotificationInterval(interval: Int) {
        viewModelScope.launch {
            _state.emit(state.value.copy(notificationInterval = interval))
        }
    }
}