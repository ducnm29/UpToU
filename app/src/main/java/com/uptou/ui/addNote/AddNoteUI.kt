package com.uptou.ui.addNote

import android.util.Log
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.maxkeppeker.sheets.core.models.base.rememberSheetState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarConfig
import com.maxkeppeler.sheets.calendar.models.CalendarSelection

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNoteUI(
    viewModel: AddNoteViewModel
) {
    val calendarState = rememberSheetState()

    CalendarDialog(
        config = CalendarConfig(
            monthSelection = true,
            yearSelection = true
        ),
        state = calendarState,
        selection = CalendarSelection.Date{
            Log.e("date", it.toString())
        })

    Button(onClick = {
        calendarState.show()
    }) {
        Text(text = "Add")
    }
}