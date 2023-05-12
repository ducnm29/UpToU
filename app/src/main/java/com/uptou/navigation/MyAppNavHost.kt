package com.uptou.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.uptou.ui.favourite.FavouriteUI
import com.uptou.ui.home.HomeUI
import com.uptou.ui.setting.SettingUI

@Composable
fun MyAppNavHost(
    modifier: Modifier,
    navController: NavController,
    startDestination : String
) {
    NavHost(
        navController = navController as NavHostController,
        startDestination = startDestination ){
        composable("home_screen"){
            HomeUI()
        }
        composable("favourite_screen"){
            FavouriteUI()
        }
        composable("setting_screen"){
            SettingUI()
        }
    }
}