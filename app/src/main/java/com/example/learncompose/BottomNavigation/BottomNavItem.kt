package com.example.learncompose.BottomNavigation

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val title: String,
    val route: String,
    val selectedicon: ImageVector,
    val unselectedicon: ImageVector,
    val hasNews: Boolean,
    val badges: Int

)
