package com.uptou.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AlertDialogMessage(
    title: String,
    message: String,
    isShowDialog: Boolean,
    onClickDismissDialog :() ->Unit) {
    if(isShowDialog){
        AlertDialog(
            onDismissRequest = { onClickDismissDialog() },
            dismissButton = {
                Button(
                    onClick = { onClickDismissDialog() },
                    modifier = Modifier.padding(vertical = 8.dp)) {
                    Text(text = "Cancel")
                }
            },
            confirmButton = {
                Button(
                    onClick =  onClickDismissDialog ,
                    modifier = Modifier.padding(vertical = 8.dp)) {
                    Text(text = "Oke")
                }
            },
            title = { Text(text = title) },
            text = { Text(text = message) }
        )
    }
}