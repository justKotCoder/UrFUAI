package com.example.settings.notification


data class NotificationSettingsState(
    val pushNotificationsEnabled: Boolean = false,
    val notificationInterval: Int = 30 // minutes
)