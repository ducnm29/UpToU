package com.uptou

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.uptou.navigation.BaseScreen
import com.uptou.navigation.MyAppNavHost
import com.uptou.ui.AppNavigation
import com.uptou.ui.theme.UpToUTheme

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
                navController = navController )
        }
    ) {it ->
        MyAppNavHost(
            modifier = modifier,
            navController = navController,
            startDestination = BaseScreen.HomeScreen.route)
    }
}