package com.uptou.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.uptou.ui.component.NoteItemUI
import com.uptou.ui.navigation.BaseScreen

@Composable
fun HomeUI(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: AddNoteViewModel
) {
    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Home")
        //Spacer(modifier = modifier.size(10.dp))
        val noteList = viewModel.noteList.collectAsState().value
        LazyColumn(
            modifier = Modifier.padding(4.dp)){

            items(noteList){
                NoteItemUI(note = it)
            }
        }
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
//        NoteItemUI(
//            Note(1,"Minh Duc","2023/05/30",2,"Bun Ca'",32000f)
//        )
    }

}