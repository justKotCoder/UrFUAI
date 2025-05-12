package com.coderkot.home.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coderkot.home.R

@Composable
fun NewsCard(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    BaseCard(
        onClick = onClick,
        modifier = modifier.fillMaxWidth() // Увеличили высоту для двух новостей
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Верхняя строка с иконкой и заголовком
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.news),
                        contentDescription = "Новости",
                        modifier = Modifier.size(20.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )

                    Text(
                        text = "Новости",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Medium
                        )
                    )
                }

                Icon(
                    painter = painterResource(id = R.drawable.arrow_forward),
                    contentDescription = "Стрелка",
                    modifier = Modifier.size(10.dp),
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Первая новость
            NewsItem(
                title = "Получение второго образования параллельно с первым",
                date = "02.04.2025"
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Вторая новость
            NewsItem(
                title = "Студенческий фестиваль «Медиапром»",
                date = "16.04.2025"
            )
        }
    }
}

@Composable
private fun NewsItem(
    title: String,
    date: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        // Заголовок новости (DM Sans Bold 14px)
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            ),
            color = MaterialTheme.colorScheme.onSurface
        )

        Spacer(modifier = Modifier.height(4.dp))

        // Дата новости (Akatab Regular 12px)
        Text(
            text = date,
            style = MaterialTheme.typography.labelMedium.copy(
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp
            ),
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
@Preview
fun NewsCardPreview() {
    NewsCard(onClick = {})
}
