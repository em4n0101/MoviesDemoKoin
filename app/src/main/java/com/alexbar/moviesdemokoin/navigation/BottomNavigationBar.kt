package com.alexbar.moviesdemokoin.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.currentBackStackEntryAsState
import com.alexbar.moviesdemokoin.R

@Composable
fun BottomNavigationBar (
    navController: NavController
) {
    var tabItems = listOf(
        TabBarItem(
            title = stringResource(R.string.trending_movies),
            selectedIcon = Icons.Filled.List,
            unselectedIcon = Icons.Outlined.List,
            screen = Screens.TrendingMoviesScreen
        ),
        TabBarItem(
            title = stringResource(R.string.favorites_movies),
            selectedIcon = Icons.Filled.Star,
            unselectedIcon = Icons.Outlined.Star,
            screen = Screens.FavoritesMoviesScreen
        ),
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar {
        tabItems.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = if (currentRoute == item.screen.route) item.selectedIcon else item.unselectedIcon,
                        contentDescription = item.title
                    )
                },
                label = { Text(item.title) },
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}