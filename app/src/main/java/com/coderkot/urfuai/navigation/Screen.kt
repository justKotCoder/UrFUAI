package com.coderkot.urfuai.navigation

import androidx.annotation.StringRes
import com.coderkot.urfuai.R


sealed class Screen(val route: String, @StringRes val titleRes: Int) {
    object Home : Screen("home", R.string.home_title)
    object ChatBot : Screen("chat_bot", R.string.chat_title)
    object BRS : Screen("brs", R.string.brs_title)
//    object News : Screen("news", )
//    object Settings : Screen("settings")
//    object Schedule : Screen("schedule")
}
