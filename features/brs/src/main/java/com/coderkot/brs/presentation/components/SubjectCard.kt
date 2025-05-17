package com.coderkot.brs.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.coderkot.brs.R
import com.coderkot.brs.domain.model.Subject
@Composable
fun SubjectCard(
    subject: Subject,
    isExpanded: Boolean,
    onCardClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onCardClick() },
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF5F5F5)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Основная строка с названием и оценкой
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = subject.name,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFF484C52)
                )
                Text(
                    text = "%.2f".format(subject.score),
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color(0xFF0E7020)
                )
            }

            // Раскрывающаяся часть с иконками
            if (isExpanded && subject.details != null) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    // Итоги
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(R.drawable.ic_search),
                            contentDescription = "Итоги",
                            modifier = Modifier.size(16.dp),
                        )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(
                                    text = "Итоги: ${subject.details.summary}",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }

                    // Лекции
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_lecture),
                            contentDescription = "Лекции",
                            modifier = Modifier.size(16.dp),
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Лекции: ${"%.2f".format(subject.details.lecturesScore)} баллов",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color(0xFF484C52)
                        )
                    }

                    // Лабораторные
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(R.drawable.ic_labs),
                            contentDescription = "Лабы",
                            modifier = Modifier.size(16.dp),
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Лабораторные: ${"%.2f".format(subject.details.labsScore)}",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
        }
    }
}