package com.coderkot.urfuai

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import com.coderkot.brs.BrsScreen
import com.coderkot.chat.presentation.ChatScreen
import com.coderkot.home.HomeScreen
import com.coderkot.urfuai.navigation.BottomNavigationBar
import com.coderkot.urfuai.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val currentDestination by navController.currentBackStackEntryAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { BottomNavigationBar(navController) },
        topBar = {
            currentDestination?.destination?.route?.let { currentRoute ->
                if (currentRoute == "chat_bot") {
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
        val graph =
            navController.createGraph(startDestination = Screen.Home.route) {
                composable(route = Screen.Home.route) {
                    HomeScreen()
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