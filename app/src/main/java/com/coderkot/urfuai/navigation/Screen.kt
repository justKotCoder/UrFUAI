package com.coderkot.urfuai.navigation

import androidx.annotation.StringRes
import com.coderkot.urfuai.R


sealed class Screen(val route: String, @StringRes val titleRes: Int) {
    object Home : Screen("home", R.string.home_title)
    object ChatBot : Screen("chat", R.string.chat_title)
    object News : Screen("news", R.string.brs_title)
    object Settings : Screen("settings", R.string.settings_title)

    // Для параметризованных маршрутов
    fun schedule(id: String) = "schedule/$id"
    //fun news(id: String) = "news/$id"
}
