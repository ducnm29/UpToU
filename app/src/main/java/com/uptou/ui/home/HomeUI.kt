package com.uptou.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.uptou.ui.navigation.BaseScreen

@Composable
fun HomeUI(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Home")
        //Spacer(modifier = modifier.size(10.dp))
        Button(
            onClick = {
                navController.navigate(BaseScreen.AddNoteScreen.route)
            }) {
            Text(text = "Add note")
        }
    }

}