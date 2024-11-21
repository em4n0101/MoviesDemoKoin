package com.alexbar.moviesdemokoin.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun BottomNavigationGraph(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = Screens.TrendingMoviesScreen.route
    ) {
        composable(route = Screens.TrendingMoviesScreen.route) {
            Text("Screens.TrendingMoviesScreen")
        }

        composable(route = Screens.FavoritesMoviesScreen.route) {
            Text("Screens.FavoritesMoviesScreen")
        }
    }
}