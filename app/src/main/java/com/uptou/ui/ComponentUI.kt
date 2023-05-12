package com.uptou.ui


import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.uptou.navigation.BaseScreen

@Composable
fun AppNavigation(
    modifier: Modifier,
    navController: NavController) {
    val items = listOf(BaseScreen.HomeScreen, BaseScreen.FavouriteScreen, BaseScreen.SettingScreen)
//    BottomNavigation(
//        modifier = modifier
//    ){
//        items.forEach {screen ->
//            BottomNavigationItem(
//                icon = {
//                    Icon(
//                        imageVector = Icons.Default.Home,
//                        contentDescription = null)
//
//                },
//                label = {
//                        Text(text = screen.name)
//                },
//                selected = true,
//                onClick = { navController.navigate(screen.route){
//                    launchSingleTop = true
//                } })
//        }
//    }
    NavigationBar {
        items.forEach {screen->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = screen.icon,
                        contentDescription = null)

                },
                label = {
                    Text(text = screen.name)
                },
                selected = true,
                onClick = {
                    navController.navigate(screen.route){
                            launchSingleTop = true
                    }
                }
            )
        }
    }
}