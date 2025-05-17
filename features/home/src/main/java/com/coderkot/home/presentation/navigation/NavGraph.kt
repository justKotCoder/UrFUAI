package com.coderkot.home.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.coderkot.brs.BrsScreen
import com.coderkot.chat.presentation.ChatScreen
import com.coderkot.home.presentation.screen.HomeScreen
import com.example.news.NewsScreen
import com.example.schedule.presentation.screens.schedule.ScheduleScreen
import com.example.settings.SettingsScreen

fun NavGraphBuilder.homeNavGraph(navController: NavHostController) {
    // Основной граф с BottomNavigation
    navigation(
        startDestination = "home",
        route = "main_route"
    ) {
        composable("home") { HomeScreen(navController) }
        composable("chat") { ChatScreen() }
        composable("brs") { BrsScreen() }
    }

    composable("settings") {
        SettingsScreen(
            onBackClick = { navController.popBackStack() }
        )
    }

    composable("schedule") {
        ScheduleScreen(
            onBackClick = { navController.popBackStack() }) }

    composable("news/{id}") { backStackEntry ->
        NewsScreen(
            onBackClick = { navController.popBackStack() }
        )
    }
}