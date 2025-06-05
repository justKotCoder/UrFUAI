package com.coderkot.urfuai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.coderkot.home.presentation.navigation.homeNavGraph
import com.coderkot.urfuai.ui.theme.UrFUAITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UrFUAITheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "main_route"
                ) {
                    homeNavGraph(navController)
                }
            }
        }
    }
}
