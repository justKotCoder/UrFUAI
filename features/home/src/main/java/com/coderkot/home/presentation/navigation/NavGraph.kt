//package com.coderkot.home.presentation.navigation
//
//import androidx.navigation.NavGraphBuilder
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.navigation
//
//import com.coderkot.home.presentation.screen.HomeScreen
//
//fun NavGraphBuilder.mainNavGraph(navController: NavHostController) {
//    navigation(
//        startDestination = "home",
//        route = "main_route"
//    ) {
//        // Главный экран
//        composable("home") {
//            HomeScreen(navController)
//        }
//
//        // Экран расписания (открывается поверх стека)
//        composable("schedule/{id}") { backStackEntry ->
//            val id = backStackEntry.arguments?.getString("id") ?: ""
//            ScheduleScreen(id)
//        }
//
//        // Экран новостей (открывается поверх стека)
//        composable("news/{id}") { backStackEntry ->
//            val id = backStackEntry.arguments?.getString("id") ?: ""
//            NewsScreen(id)
//        }
//
//        // Экран настроек (открывается поверх стека)
//        composable("settings") {
//            SettingsScreen()
//        }
//    }
//
//    // Отдельные графы для вкладок BottomNavigation
//    navigation(
//        startDestination = "chat/main",
//        route = "chat_route"
//    ) {
//        composable("chat/main") {
//            ChatScreen()
//        }
//    }
//
//    navigation(
//        startDestination = "brs/main",
//        route = "brs_route"
//    ) {
//        composable("brs/main") {
//            BRSScreen()
//        }
//    }
//}