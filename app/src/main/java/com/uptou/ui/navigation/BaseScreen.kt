package com.uptou.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BaseScreen(val route: String, val name: String, val icon: ImageVector) {
    object HomeScreen : BaseScreen("home_screen", "Home", Icons.Default.Home)
    object FavouriteScreen : BaseScreen("favourite_screen", "Favourite", Icons.Default.Favorite)
    object SettingScreen : BaseScreen("setting_screen", "Setting", Icons.Default.AccountCircle)
    object AddNoteScreen : BaseScreen("add_note_screen", "Add note", Icons.Default.Home)
}
