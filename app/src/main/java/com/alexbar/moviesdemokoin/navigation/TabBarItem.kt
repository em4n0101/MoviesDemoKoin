package com.alexbar.moviesdemokoin.navigation

import androidx.compose.ui.graphics.vector.ImageVector

data class TabBarItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val screen: Screens
)