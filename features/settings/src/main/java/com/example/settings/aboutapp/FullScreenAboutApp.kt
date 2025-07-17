package com.example.settings.aboutapp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.settings.R

@Composable
fun FullScreenAboutApp(
    onDismiss: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                // Заголовок с кнопкой закрытия
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "О приложении",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    IconButton(onClick = onDismiss) {
                        Icon(
                            painter = painterResource(id = R.drawable.arrow_icon),
                            contentDescription = "Закрыть",
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))
                // Основной контент
                Text(
                    text = "Добро пожаловать в URFU AI — новое мобильное приложение для студентов УрФУ.",
                    style = MaterialTheme.typography.bodyLarge
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Актуальное расписание, новости по твоему курсу и умный чат-бот, который всегда поможет — всё в одном месте.",
                    style = MaterialTheme.typography.bodyLarge
                )

                Spacer(modifier = Modifier.height(32.dp))
                Divider(color = MaterialTheme.colorScheme.outline)
                Spacer(modifier = Modifier.height(24.dp))

                // Раздел "Зачем мы создали URFU AI?"
                SectionTitle("Зачем мы создали URFU AI?")

                Text(
                    text = "Потому что каждый студент сталкивается с одними и теми же вопросами:",
                    style = MaterialTheme.typography.bodyLarge
                )

                Spacer(modifier = Modifier.height(8.dp))

                BulletList(
                    items = listOf(
                        "Где сейчас пара?",
                        "Когда следующая?",
                        "Что нового в университете?",
                        "К кому обратиться за помощью?"
                    )
                )

                Spacer(modifier = Modifier.height(32.dp))
                Divider(color = MaterialTheme.colorScheme.outline)
                Spacer(modifier = Modifier.height(24.dp))

                // Раздел "Функционал"
                SectionTitle("Что имеет URFU AI?")

                FeatureItem(
                    title = "Новости по курсам",
                    features = listOf(
                        "Фильтрация по курсу (1, 2, 3-4 и т.д.)",
                        "Интеграция с таблицами университета",
                        "Отображение в виде удобной ленты"
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                FeatureItem(
                    title = "Расписание занятий",
                    features = listOf(
                        "Фильтр по дням и неделям",
                        "Поиск по преподавателям",
                        "Информация об аудиториях",
                        "Уведомления о изменениях"
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                FeatureItem(
                    title = "AI-чат-бот",
                    features = listOf(
                        "Ответы на вопросы об учёбе и расписании",
                        "Использует базу знаний и генерацию ответов",
                        "Не отвечает на не связанные с университетом темы",
                        "Возможность связи с оператором"
                    )
                )

                Spacer(modifier = Modifier.height(32.dp))
                Divider(color = MaterialTheme.colorScheme.outline)
                Spacer(modifier = Modifier.height(24.dp))

                // Раздел "Планы"
                SectionTitle("Пока нет, но скоро будет")

                BulletList(
                    items = listOf(
                        "Расширение возможностей чат-бота",
                        "Уведомления о важных новостях",
                        "Интеграции с новыми источниками информации"
                    )
                )

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "UI — минимальная, осознанная, полная.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )

                Text(
                    text = "Создан студентами — для студентов",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Composable
private fun SectionTitle(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(bottom = 8.dp)
    )
}

@Composable
private fun BulletList(items: List<String>) {
    Column {
        items.forEach { item ->
            Row(
                verticalAlignment = Alignment.Top,
                modifier = Modifier.padding(vertical = 4.dp)
            ) {
                Text(
                    text = "— ",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = item,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Composable
private fun FeatureItem(title: String, features: List<String>) {
    Column {
        Text(
            text = "• $title",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(4.dp))

        features.forEach { feature ->
            Text(
                text = "  - $feature",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
    }
}
