package com.example.news.presentation.screens.newslist

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.news.presentation.screens.newslist.components.NewsCard
import com.example.news.presentation.screens.newslist.components.NewsDetailsDialog
import org.koin.androidx.compose.koinViewModel

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsScreen(
    onBackClick: () -> Unit,
    viewModel: NewsListViewModel = koinViewModel()
) {
    val news by viewModel.news.collectAsState()
    val selectedNews by viewModel.selectedNews.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Новости") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Назад")
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(news) { newsItem ->
                NewsCard(
                    news = newsItem,
                    onClick = { viewModel.selectNews(newsItem) }
                )
            }
        }

        selectedNews?.let { news ->
            NewsDetailsDialog(
                news = news,
                onDismiss = { viewModel.dismissDetails() }
            )
        }
    }
}