package com.uptou.ui.component


import androidx.compose.material3.*
import androidx.compose.material3.NavigationBarDefaults.containerColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.uptou.ui.navigation.BaseScreen

@Composable
fun AppNavigation(
    modifier: Modifier,
    navController: NavController) {
    val items = listOf(BaseScreen.HomeScreen, BaseScreen.FavouriteScreen, BaseScreen.SettingScreen)
    var selectedItem = remember { mutableStateOf(0) }
    NavigationBar(
        modifier = Modifier,
        containerColor = containerColor,
        contentColor = MaterialTheme.colorScheme.contentColorFor(containerColor),
        tonalElevation = NavigationBarDefaults.Elevation,
        windowInsets = NavigationBarDefaults.windowInsets,
    ) {
        items.forEachIndexed { index, screen ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = screen.icon,
                        contentDescription = null)
                },
                label = {
                    Text(text = screen.name)
                },
                selected = selectedItem.value == index,
                onClick = {
                    selectedItem.value = index
                    navController.navigate(screen.route){
                        popUpTo(navController.graph.findStartDestination().id){
                            saveState = true
                        }
                            launchSingleTop = true
                            restoreState = true
                    }
                }
            )
        }
    }
}


