package com.uptou.ui.addNote

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
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
        selection = CalendarSelection.Date {
            Log.e("date", it.toString())
        }
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(
            value = viewModel.userPaid,
            onValueChange = { userPaid ->
                viewModel.setUserPaid(userPaid)
            },
            label = { Text(text = "User paid") })

        Spacer(modifier = Modifier.height(10.dp))


        OutlinedTextField(
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            value = viewModel.userNumber.toString(),
            onValueChange = { userNumber ->
                viewModel.setUserNumbers(userNumber)
            },
            label = { Text(text = "Users number") })

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            value = viewModel.total.toString(),
            onValueChange = { total ->
                viewModel.setTotal(total)
            },
            label = { Text(text = "Total") })

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = viewModel.food,
            onValueChange = { food ->
                viewModel.setFood(food)
            },
            label = { Text(text = "Food") })
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = viewModel.date,
            onValueChange = { date ->
                viewModel.setDate(date)
            },
            label = { Text(text = "Date") })

        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = { }) {
            Text(text = "Submit")
        }
    }

}