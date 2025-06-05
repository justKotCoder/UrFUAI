// SettingsScreen.kt
package com.example.settings

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.settings.notification.NotificationSettingsViewModel

@Composable
fun SettingsScreen(onBackClick: () -> Boolean) {
    var showNotificationDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F6F7)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = "",
                onValueChange = { },
                modifier = Modifier
                    .width(358.dp)
                    .height(48.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                label = { Text(text = "ФИО") }
            )
            Spacer(modifier = Modifier.height(30.dp))

            TextField(
                value = "",
                onValueChange = { },
                modifier = Modifier
                    .width(358.dp)
                    .height(48.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                label = { Text(text = "РИ - ") }
            )
            Spacer(modifier = Modifier.height(30.dp))

            Button(
                onClick = { showNotificationDialog = true },
                modifier = Modifier
                    .width(358.dp)
                    .height(44.dp),
                border = BorderStroke(1.dp, Color(0xFFEF4836)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Icon(
                        painterResource(R.drawable.notification_icon),
                        contentDescription = "",
                        tint = Color(0xFFEF4836)
                    )
                    Text(
                        text = "Уведомления",
                        color = Color(0xFF484C52)
                    )
                    Icon(
                        painterResource(R.drawable.arrow_icon),
                        contentDescription = "",
                        tint = Color(0xFF484C52)
                    )
                }
            }
        }
    }

    if (showNotificationDialog) {
        FullScreenNotificationDialog(
            onDismiss = { showNotificationDialog = false }
        )
    }
}

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
    Box(
        modifier = Modifier
            .fillMaxSize()

            .clickable(onClick = onDismiss)
            .background(Color.Black.copy(alpha = 0.5f)),
        contentAlignment = Alignment.Center
    ) {
        // Основная карточка
        Card(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth()
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
                        Column {
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
                            onCheckedChange = { viewModel.togglePushNotifications() }
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
}

private fun minutesToRussian(minutes: Int): String {
    return when {
        minutes % 100 in 11..14 -> "минут"
        minutes % 10 == 1 -> "минуту"
        minutes % 10 in 2..4 -> "минуты"
        else -> "минут"
    }
}
@Preview
@Composable
fun SettingsScreenPreview() {
    FullScreenNotificationDialog( onDismiss = {})
}