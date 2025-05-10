package com.coderkot.home.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.coderkot.brs.BrsScreen
import com.coderkot.chat.presentation.ChatScreen
import com.coderkot.home.presentation.screen.HomeScreen
import com.coderkot.schedule.presentation.ScheduleScreen
import com.example.news.NewsScreen
import com.example.settings.SettingsScreen
// features/home/presentation/navigation/NavGraph.kt
fun NavGraphBuilder.mainNavGraph(navController: NavHostController) {
    navigation(
        startDestination = "home",
        route = "main_route"
    ) {
        composable("home") { HomeScreen(navController) }
        composable("schedule/{id}") { backStackEntry ->
            ScheduleScreen(backStackEntry.arguments?.getString("id") ?: "")
        }
        composable("news/{id}") { backStackEntry ->
            NewsScreen(backStackEntry.arguments?.getString("id") ?: "")
        }
        composable("chat") { ChatScreen() }
        composable("brs") { BrsScreen() }
        composable("settings") { SettingsScreen() }
    }
}