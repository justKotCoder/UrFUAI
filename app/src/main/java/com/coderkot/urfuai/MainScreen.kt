package com.coderkot.urfuai

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import com.coderkot.brs.BrsScreen
import com.coderkot.chat.presentation.ChatScreen
import com.coderkot.home.presentation.screen.HomeScreen
import com.coderkot.urfuai.navigation.BottomNavigationBar
import com.coderkot.urfuai.navigation.Screen

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        val graph =
            navController.createGraph(startDestination = Screen.Home.route) {
                composable(route = Screen.Home.route) {
                    HomeScreen(navController = navController)
                }
                composable(route = Screen.BRS.route) {
                    BrsScreen()
                }
                composable(route = Screen.ChatBot.route) {
                    ChatScreen()
                }
            }
        NavHost(
            navController = navController,
            graph = graph,
            modifier = Modifier.padding(innerPadding)
        )
    }
}