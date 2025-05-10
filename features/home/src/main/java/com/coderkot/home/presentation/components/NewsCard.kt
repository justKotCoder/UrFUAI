package com.coderkot.home.presentation.components




import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.coderkot.home.domain.model.HomeItem

// features/home/presentation/components/NewsCard.kt
@Composable
fun NewsCard(
    item: HomeItem.News,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    BaseCard(onClick = onClick, modifier = modifier) {
        Column {
            Text(
                text = item.title,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = item.content)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = item.date,
                style = MaterialTheme.typography.labelSmall,
                color = Color.Gray
            )
        }
    }
}