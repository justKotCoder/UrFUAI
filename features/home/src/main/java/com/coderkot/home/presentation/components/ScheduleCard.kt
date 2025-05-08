package com.coderkot.home.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.coderkot.home.domain.model.HomeItem

// features/home/presentation/components/ScheduleCard.kt
@Composable
fun ScheduleCard(
    item: HomeItem.Schedule,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    BaseCard(onClick = onClick, modifier = modifier) {
        Column {
            Text(
                text = item.time,
                style = MaterialTheme.typography.titleMedium,
                color = Color(0xFF0ACEB0)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = item.subject, style = MaterialTheme.typography.bodyLarge)
            Text(text = item.type, style = MaterialTheme.typography.bodyMedium)

            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = item.isCompleted,
                    onCheckedChange = null,
                    colors = CheckboxDefaults.colors(checkedColor = Color(0xFF0ACEB0))
                )
                Text(text = item.location, modifier = Modifier.padding(start = 8.dp))
            }

            Text(text = item.teacher, style = MaterialTheme.typography.bodySmall)
        }
    }
}