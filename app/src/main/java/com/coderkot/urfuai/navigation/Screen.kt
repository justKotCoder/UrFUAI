package com.coderkot.urfuai.navigation


sealed class Screen(val route: String) {
    object Home : Screen("home")
    object ChatBot : Screen("chat_bot")
    object BRS : Screen("brs")
    object News : Screen("news")
    object Settings : Screen("settings")
    object Schedule : Screen("schedule")
}
