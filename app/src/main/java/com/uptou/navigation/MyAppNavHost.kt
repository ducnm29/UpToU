package com.uptou.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.uptou.ui.addNote.AddNoteUI
import com.uptou.ui.addNote.AddNoteViewModel
import com.uptou.ui.favourite.FavouriteUI
import com.uptou.ui.home.HomeUI
import com.uptou.ui.setting.SettingUI

@Composable
fun MyAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(BaseScreen.FavouriteScreen.route) {
            FavouriteUI()
        }
        homeGraph(navController)
        composable(BaseScreen.SettingScreen.route) {
            SettingUI()
        }
    }
}

fun NavGraphBuilder.homeGraph(navController: NavHostController) {
    navigation(startDestination = "home", route = BaseScreen.HomeScreen.route) {
        composable("home") {
            HomeUI(navController = navController)
        }
        composable(BaseScreen.AddNoteScreen.route) {
            AddNoteUI(AddNoteViewModel())
        }
    }
}