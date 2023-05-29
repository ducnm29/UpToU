package com.uptou.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.uptou.R
import com.uptou.model.Note

@Composable
fun NoteItemUI(
    note: Note,
    modifier: Modifier = Modifier
) {
    Row {
        Image(
            painter = painterResource(id = R.drawable.u_sure),
            contentDescription = "NoteImage",
            Modifier.size(48.dp))
    }
}