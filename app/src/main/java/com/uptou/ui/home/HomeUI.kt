package com.uptou.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.uptou.model.Note
import com.uptou.ui.addNote.AddNoteViewModel
import com.uptou.ui.component.ImageCarousel
import com.uptou.ui.component.NoteItemUI
import com.uptou.ui.navigation.BaseScreen

@Composable
fun HomeUI(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: AddNoteViewModel
) {
    val scrollState = rememberScrollState()
    Column(
        modifier
            .fillMaxWidth()
            .padding(start = 5.dp, end = 5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ImageCarousel()
        val noteList = viewModel.noteList.collectAsState().value
        LazyColumn(
            modifier = Modifier
                .padding(4.dp)
        ){
            items(noteList){
                NoteItemUI(note = it)
                Spacer(modifier = modifier.size(5.dp))
            }
            item() {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(
                        onClick = {
                            navController.navigate(BaseScreen.AddNoteScreen.route)
                        }) {
                        Text(text = "Add note")
                    }
                    Button(
                        onClick = {
                            viewModel.readAllNotesLocal()
                        }) {
                        Text(text = "Read all notes")
                    }
                }
            }
        }

    }
}