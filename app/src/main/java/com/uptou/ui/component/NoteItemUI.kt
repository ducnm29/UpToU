package com.uptou.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uptou.R
import com.uptou.model.Note

@Composable
fun NoteItemUI(
    note: Note,
    modifier: Modifier = Modifier
        .fillMaxWidth()
//        .background(
//            color = C
//        )

) {
    Row {
        Spacer(modifier = Modifier.size(15.dp))
        Column(modifier = Modifier.fillMaxHeight()) {
            Spacer(modifier = Modifier.size(10.dp))
            Image(
                painter = painterResource(id = R.drawable.u_sure),
                contentScale = ContentScale.Crop,
                contentDescription = "NoteImage",
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape))
        }
        Spacer(modifier = Modifier.size(15.dp))
        Column() {
            Row {
                Text(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    text ="Date: ")
                Text(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    text = note.date)
            }
            Spacer(modifier = Modifier.size(3.dp))
            Row {
                Text(
                    fontWeight = FontWeight.Medium,
                    text ="Food: ")
                Text(
                    fontWeight = FontWeight.Medium,
                    text = note.food)
            }
            Spacer(modifier = Modifier.size(3.dp))
            Row {
                Text(
                    fontWeight = FontWeight.Medium,
                    text ="Total: ")
                Text(
                    fontWeight = FontWeight.Medium,
                    text = note.total.toString())
            }
            Spacer(modifier = Modifier.size(3.dp))
            Row {
                Text(
                    fontWeight = FontWeight.Medium,
                    text ="User paid: ")
                Text(
                    fontWeight = FontWeight.Medium,
                    text = note.username)
            }
        }

    }
}