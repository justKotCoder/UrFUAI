package com.coderkot.urfuai.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.coderkot.urfuai.R

@Composable
fun BottomNavigationBar(
    navController: NavController,
) {

    val navigationItems = listOf(
        NavigationItem(
            title = "Домой",
            icon = R.drawable.li_home,
            route = Screen.Home.route
        ),
        NavigationItem(
            title = "Чат",
            icon = R.drawable.fluent_chat,
            route = Screen.ChatBot.route
        ),
        NavigationItem(
            title = "БРС",
            icon = R.drawable.planet,
            route = Screen.BRS.route
        )
    )

    NavigationBar(
        tonalElevation = 4.dp
    ) {
        navigationItems.forEachIndexed { index, item ->
            val currentBackStack by navController.currentBackStackEntryAsState()
            val currentDestination = currentBackStack?.destination
            val selected = currentDestination?.hierarchy?.any {
                it.route == item.route
            } == true
            NavigationBarItem(
                selected = selected,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = item.title,
                            modifier = Modifier.size(24.dp),
                            tint = if (selected) Color(0xFF0ACEB0) else Color.Gray
                        )
                        if (selected) {
                            Text(
                                text = item.title,
                                style = MaterialTheme.typography.labelSmall,
                                color = Color(0xFF0ACEB0)
                            )
                        }
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFF0ACEB0),
                    unselectedIconColor = Color.Gray,
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}

data class NavigationItem(
    val title: String,
    val icon: Int,
    val route: String
)