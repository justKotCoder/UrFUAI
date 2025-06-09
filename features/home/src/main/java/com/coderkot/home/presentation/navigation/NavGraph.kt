package com.coderkot.home.presentation.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation

import com.coderkot.chat.presentation.ChatScreen
import com.coderkot.home.presentation.screen.HomeScreen
import com.example.news.presentation.screens.newslist.NewsScreen
import com.example.schedule.presentation.screens.schedule.ScheduleScreen
import com.example.settings.SettingsScreen
import com.example.tutor.TutorDialog


@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.homeNavGraph(navController: NavHostController) {
    // Основной граф с BottomNavigation

    navigation(
        startDestination = "home",
        route = "main_route"
    ) {
        composable("home") { HomeScreen(navController) }
        composable("chat") { ChatScreen() }



        composable("news") {
            val bottomBarVisible = remember { mutableStateOf(true) }
            NewsScreen(
                onBackClick = { navController.popBackStack() },
                bottomBarVisible = bottomBarVisible
            )
        }
    }

    composable("settings") {
        SettingsScreen(
            onBackClick = { navController.popBackStack() }
        )
    }

    composable("schedule") {
        ScheduleScreen(
            onBackClick = { navController.popBackStack() }) }

    composable("tutor") {
        TutorDialog(
            onDismiss = { navController.popBackStack() },
            onSubmit = { _, _ -> }
        )
    }
}