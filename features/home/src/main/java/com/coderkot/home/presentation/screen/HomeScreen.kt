package com.coderkot.home.presentation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.coderkot.home.domain.model.HomeItem
import com.coderkot.home.presentation.components.*
import com.coderkot.home.presentation.viewmodel.HomeViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsState()

    when (state) {
        is HomeViewModel.HomeState.Loading -> LoadingView()
        is HomeViewModel.HomeState.Success -> {
            val items = (state as HomeViewModel.HomeState.Success).items
            HomeContent(items = items, navController = navController)
        }
        is HomeViewModel.HomeState.Error -> ErrorView((state as HomeViewModel.HomeState.Error).message)
    }
}

@Composable
private fun HomeContent(
    items: List<HomeItem>,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(items) { item ->
            when (item) {
                is HomeItem.Schedule -> ScheduleCard(
                    item = item,
                    onClick = { navController.navigate("schedule/${item.id}") }
                )
                is HomeItem.News -> NewsCard(
                    item = item,
                    onClick = { navController.navigate("news/${item.id}") }
                )
                is HomeItem.ChatBot -> ChatBotCard(
                    onClick = { navController.navigate("chat") }
                )
                is HomeItem.BRS -> BRSCard(
                    onClick = { navController.navigate("brs") }
                )
                is HomeItem.Settings -> SettingsCard(
                    onClick = { navController.navigate("settings") }
                )
            }
        }
    }
}

@Composable
private fun LoadingView() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator(color = Color(0xFF0ACEB0))
    }
}

@Composable
private fun ErrorView(message: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = message,
            color = MaterialTheme.colorScheme.error,
            modifier = Modifier.padding(16.dp)
        )
    }
}