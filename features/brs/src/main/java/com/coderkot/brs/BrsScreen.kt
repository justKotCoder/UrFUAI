package com.coderkot.brs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.coderkot.brs.presentation.components.SubjectCard
import com.coderkot.brs.presentation.viewmodel.SubjectsViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun BrsScreen(viewModel: SubjectsViewModel = koinViewModel()) {
    val subjects by viewModel.subjects.collectAsState(initial = emptyList())
    val expandedIds by viewModel.expandedSubjectIds.collectAsState()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(subjects) { subject ->
            SubjectCard(
                subject = subject,
                isExpanded = expandedIds.contains(subject.id),
                onCardClick = { viewModel.toggleExpanded(subject.id) }
            )
        }
    }
}