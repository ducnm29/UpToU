package com.uptou.ui.addNote

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.uptou.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor(
    noteRepository: NoteRepository
) : ViewModel() {
    private val _userPaid = mutableStateOf("")
    private val _userNumber = mutableStateOf(0)
    private val _total = mutableStateOf(0.0f)
    private val _date = mutableStateOf("")
    private val _food = mutableStateOf("")
    val userPaid: String
        get() = _userPaid.value
    val userNumber: Int
        get() = _userNumber.value
    val total: Float
        get() = _total.value
    val date: String
        get() = _date.value
    val food: String
        get() = _food.value

    fun setUserPaid(userPaid: String) {
        _userPaid.value = userPaid
    }

    fun setUserNumbers(num: String) {
        try {
            _userNumber.value = num.toInt()
        } catch (ex: Exception) {
            _userNumber.value = 0
        }
    }

    fun setTotal(total: String) {
        try {
            _total.value = total.toFloat()
        } catch (ex: Exception) {
            _total.value = 0f
        }
    }

    fun setFood(food: String) {
        _food.value = food
    }

    fun setDate(date: String) {
        _date.value = date
    }

}