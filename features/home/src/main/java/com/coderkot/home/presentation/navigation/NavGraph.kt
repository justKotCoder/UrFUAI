package com.coderkot.home.presentation.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.coderkot.chat.presentation.ChatScreen
import com.coderkot.home.presentation.screen.HomeScreen
import com.example.news.presentation.screens.newslist.NewsScreen
import com.example.schedule.presentation.screens.schedule.ScheduleScreen
import com.example.settings.SettingsScreen
import com.example.tutor.TutorScreen
import org.koin.androidx.compose.koinViewModel

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.homeNavGraph(navController: NavHostController) {
    navigation(
        startDestination = "home",
        route = "main_route"
    ) {
        composable("home") {
            HomeScreen(
                onScheduleClick = { navController.navigate("schedule") },
                onNewsClick = { navController.navigate("news") },
                onChatClick = { navController.navigate("chat") },
                onTutorClick = { navController.navigate("tutor") },
                onSettingsClick = { navController.navigate("settings") }
            )
        }

        composable("chat") {
            ChatScreen()
        }

        composable("news") {
            NewsScreen(
                onBackClick = { navController.popBackStack() },
                viewModel = koinViewModel()
            )
        }

        composable("schedule") {
            ScheduleScreen(onBackClick = { navController.popBackStack() })
        }

        composable("settings") {
            SettingsScreen(onBackClick = { navController.popBackStack() })
        }

        composable("tutor") {
            TutorScreen(onBackClick = { navController.popBackStack() })
        }
    }
}