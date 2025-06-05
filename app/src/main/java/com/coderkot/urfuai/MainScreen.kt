package com.coderkot.urfuai

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.coderkot.chat.presentation.ChatScreen
import com.coderkot.home.presentation.screen.HomeScreen
import com.coderkot.urfuai.navigation.BottomNavigationBar
import com.coderkot.urfuai.navigation.Screen
import com.example.news.presentation.screens.newslist.NewsScreen
import com.example.schedule.presentation.screens.schedule.ScheduleScreen
import com.example.settings.SettingsScreen

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val currentDestination by navController.currentBackStackEntryAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigationBar(navController)
        },
        topBar = {
            currentDestination?.destination?.route?.let { currentRoute ->
                if (currentRoute == Screen.ChatBot.route) {
                    TopAppBar(
                        title = {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "UrFU AI",
                                    color = Color(0xFFEF4836),
                                    fontSize = 30.sp,
                                    fontWeight = FontWeight.Medium
                                )
                            }
                        },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = Color(0xFFF5F6F7)
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            // Основные экраны с BottomNavigation
            composable(route = Screen.Home.route) {
                HomeScreen(navController = navController)
            }
            composable(route = Screen.News.route) {
                NewsScreen(
                    onBackClick = { navController.popBackStack() },
                    bottomBarVisible = remember { mutableStateOf(true) },
                )
            }
            composable(route = Screen.ChatBot.route) {
                ChatScreen()
            }

            // Экран расписания
            composable(
                route = "schedule/{id}",
                arguments = listOf(navArgument("id") { type = NavType.StringType })
            ) { backStackEntry ->
                ScheduleScreen(
                    onBackClick = { navController.popBackStack() }
                )
            }


            // Экран новостей
            composable(
                route = "news/{id}",
                arguments = listOf(navArgument("id") { type = NavType.StringType })
            ) { backStackEntry ->
                NewsScreen(
                    onBackClick = { navController.popBackStack()
                        navController.navigate(Screen.Home.route) },
                    bottomBarVisible = remember { mutableStateOf(false) })
            }

            // Экран настроек
            composable("settings") {
                SettingsScreen( onBackClick = { navController.popBackStack() })
            }
        }
    }
}