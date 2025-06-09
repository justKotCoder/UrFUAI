package com.example.settings

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.settings.aboutapp.FullScreenAboutApp
import com.example.settings.notification.FullScreenNotificationDialog
import com.example.settings.notification.NotificationSettingsViewModel

@Composable
fun SettingsScreen(onBackClick: () -> Boolean) {
    var showNotificationDialog by remember { mutableStateOf(false) }
    var showAboutAppDialog by remember { mutableStateOf(false) }
    var showThemeDialog by remember { mutableStateOf(false) }
    var fio by remember { mutableStateOf("") }
    var riNumber by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F6F7)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(30.dp))

            // Поле ввода ФИО
            TextField(
                value = fio,
                onValueChange = { fio = it },
                modifier = Modifier
                    .width(358.dp)
                    .height(48.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedLabelColor = Color.Transparent,
                    unfocusedLabelColor = Color.Gray
                ),
                label = { Text("ФИО") },
                singleLine = true
            )

            Spacer(modifier = Modifier.height(30.dp))

            // Поле ввода номера группы
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .width(358.dp)
                    .height(48.dp)
                    .background(Color.White, RoundedCornerShape(4.dp))
            ) {
                Text(
                    text = "РИ-",
                    color = Color.Gray,
                    modifier = Modifier.padding(start = 16.dp)
                )
                BasicTextField(
                    value = riNumber,
                    onValueChange = { if (it.all { c -> c.isDigit() }) riNumber = it },
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 8.dp),
                    singleLine = true,
                    decorationBox = { innerTextField ->
                        if (riNumber.isEmpty()) {
                            Text("230950", color = Color.LightGray)
                        }
                        innerTextField()
                    }
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Кнопка отправки
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
            ) {
                Button(
                    onClick = { /* Обработка отправки */ },
                    modifier = Modifier
                        .width(120.dp)
                        .height(30.dp)
                        .padding(start = 20.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFF97537)
                    ),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text(
                        text = "ОТПРАВИТЬ",
                        color = Color.White,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            // Кнопка уведомлений
            SettingsButton(
                icon = R.drawable.notification_icon,
                text = "Уведомления",
                borderColor = Color(0xFFEF4836),
                onClick = { showNotificationDialog = true }
            )

            Spacer(modifier = Modifier.height(30.dp))

            // Кнопка темы
            SettingsButton(
                icon = R.drawable.reverce_ic,
                text = "Тема",
                borderColor = Color(0xFF484C52),
                onClick = { showThemeDialog = true }
            )

            Spacer(modifier = Modifier.height(30.dp))

            // Кнопка о приложении
            SettingsButton(
                icon = R.drawable.dialog_ic,
                text = "О приложении",
                borderColor = Color(0xFF0ACEB0),
                onClick = { showAboutAppDialog = true }
            )
        }

        // Диалог уведомлений
        if (showNotificationDialog) {
            val viewModel: NotificationSettingsViewModel = viewModel()
            FullScreenNotificationDialog(
                onDismiss = { showNotificationDialog = false },
                viewModel = viewModel
            )
        }

        // Диалог о приложении
        if (showAboutAppDialog) {
            FullScreenAboutApp { showAboutAppDialog = false }
        }

        // Диалог выбора темы
        if (showThemeDialog) {
            ThemeSelectionDialog { showThemeDialog = false }
        }
    }
}

@Composable
private fun SettingsButton(
    icon: Int,
    text: String,
    borderColor: Color,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .width(358.dp)
            .height(44.dp),
        border = BorderStroke(1.dp, borderColor),
        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(icon),
                contentDescription = null,
                tint = borderColor
            )
            Text(
                text = text,
                color = Color(0xFF484C52),
                modifier = Modifier.padding(start = 8.dp)
            )
            Icon(
                painter = painterResource(R.drawable.arrow_icon),
                contentDescription = null,
                tint = Color(0xFF484C52)
            )
        }
    }
}



@Composable
private fun ThemeSelectionDialog(onDismiss: () -> Unit) {
    var selectedTheme by remember { mutableStateOf("Системная") }

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.5f))
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .align(Alignment.BottomCenter),
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
                color = Color.White
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Выбор темы",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    // Верхний ряд карточек
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        ThemeCard(
                            title = "Системная",
                            description = "Как в системе",
                            icon = R.drawable.system_theme_ic,
                            isSelected = selectedTheme == "Системная",
                            onSelect = { selectedTheme = "Системная" },
                            width = 160.dp,  // Ширина карточки
                            height = 120.dp  // Высота карточки
                        )

                        Spacer(modifier = Modifier.width(12.dp))

                        ThemeCard(
                            title = "Светлая",
                            description = "Светлый интерфейс",
                            icon = R.drawable.light_theme_ic,
                            isSelected = selectedTheme == "Светлая",
                            onSelect = { selectedTheme = "Светлая" },
                            width = 160.dp,
                            height = 120.dp
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Нижняя карточка
                    ThemeCard(
                        title = "Тёмная",
                        description = "Тёмный интерфейс",
                        icon = R.drawable.dark_theme_ic,
                        isSelected = selectedTheme == "Тёмная",
                        onSelect = { selectedTheme = "Тёмная" },
                        width = 160.dp,
                        height = 120.dp,
                        modifier = Modifier.width(160.dp) // Фиксированная ширина для центрирования
                    )
                }
            }
        }
    }
}

@Composable
private fun ThemeCard(
    title: String,
    description: String,
    icon: Int,
    isSelected: Boolean,
    onSelect: () -> Unit,
    width: Dp,
    height: Dp,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .width(width)
            .height(height)
            .clickable { onSelect() },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF7F7F7)
        ),
        border = if (isSelected) BorderStroke(2.dp, Color(0xFF0ACEB0)) else null
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Иконка (без указания tint)
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier.size(28.dp)
            )

            // Остальной код без изменений
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF484C52),
                    fontSize = 15.sp
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFF888C94),
                    textAlign = TextAlign.Center,
                    fontSize = 13.sp
                )
            }

            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}

@Preview
@Composable
fun SettingsScreenPreview() {
    SettingsScreen {  true }
}