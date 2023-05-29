package com.uptou

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.uptou.ui.navigation.BaseScreen
import com.uptou.ui.navigation.MyAppNavHost
import com.uptou.ui.component.AppNavigation
import com.uptou.ui.theme.UpToUTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UpToUTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainUI(Modifier)
                }
            }
        }
    }
}

@Composable
fun MainUI(
    modifier: Modifier
) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            AppNavigation(
                modifier = modifier,
                navController = navController
            )
        }
    ) {
        MyAppNavHost(
            modifier = modifier,
            navController = navController,
            startDestination = BaseScreen.HomeScreen.route
        )
    }
}