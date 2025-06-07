package com.example.settings.notification

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.settings.R

@Composable
fun FullScreenNotificationDialog(
    onDismiss: () -> Unit,
    viewModel: NotificationSettingsViewModel = viewModel()
) {
    val state by viewModel.state.collectAsState()
    var expanded by remember { mutableStateOf(false) }
    val intervals = listOf(30, 60, 90)
    val intervalTexts = intervals.map { "за $it ${minutesToRussian(it)}" }

    // Фон для закрытия по клику вне карточки
//    Box(
//        modifier = Modifier
//            .clickable(onClick = onDismiss)
//            .background(Color.Black.copy(alpha = 0.5f)),
//        contentAlignment = Alignment.Center
//    ) {
    // Основная карточка
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .clickable { /* Предотвращаем закрытие при клике на карточку */ },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Настройка уведомлений",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Карточка с пуш-уведомлениями
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFF7F7F7)
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier.weight(1f, fill = true)
                    ) {
                        Text(
                            text = "Пуш уведомления",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = "Разрешить приложению отправлять push-уведомления на экран блокировки",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Gray
                        )
                    }
                    Switch(
                        checked = state.pushNotificationsEnabled,
                        onCheckedChange = { viewModel.togglePushNotifications() },
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .size(25.dp),
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = Color.White,
                            checkedTrackColor = Color(0xFF0ACEB0),
                            uncheckedThumbColor = Color.White,
                            uncheckedTrackColor = Color(0xFFBDBDBD)
                        )
                    )
                }

            }

            // Карточка с уведомлениями о парах (только выпадающий список)
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFF7F7F7)
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Column {
                        Text(
                            text = "Уведомления о предстоящих парах",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = "Разрешить приложению отправлять уведомления о запланированных парах",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Gray,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                    }

                    Text(
                        text = "Выберите интервал",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    // Выпадающий список
                    Box(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        OutlinedButton(
                            onClick = { expanded = true },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.outlinedButtonColors(
                                containerColor = Color.White
                            )
                        ) {
                            Text(
                                text = intervalTexts[intervals.indexOf(state.notificationInterval)],
                                modifier = Modifier.weight(1f),
                                textAlign = TextAlign.Start
                            )
                            Icon(
                                painter = painterResource(R.drawable.arrow_icon),
                                contentDescription = "Выберите интервал"
                            )
                        }
                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            intervals.forEachIndexed { index, interval ->
                                DropdownMenuItem(
                                    text = { Text(intervalTexts[index]) },
                                    onClick = {
                                        viewModel.updateNotificationInterval(interval)
                                        expanded = false
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}


private fun minutesToRussian(minutes: Int): String {
    return when {
        minutes % 100 in 11..14 -> "минут"
        minutes % 10 == 1 -> "минуту"
        minutes % 10 in 2..4 -> "минуты"
        else -> "минут"
    }
}
