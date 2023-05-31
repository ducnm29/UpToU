package com.uptou.ui.addNote

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uptou.model.Note
import com.uptou.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor(
    private val noteRepository: NoteRepository
) : ViewModel() {
    private val _userPaid = mutableStateOf("")
    private val _userNumber = mutableStateOf("")
    private val _total = mutableStateOf("")
    private val _date = mutableStateOf("")
    private val _food = mutableStateOf("")
    private val _isShowDialog = mutableStateOf(false)
    private val _dialogMessage = mutableStateOf("")
    private val _dialogTitle = mutableStateOf("")
    private val _noteList: MutableStateFlow<List<Note>> = MutableStateFlow(listOf())
    val userPaid: String
        get() = _userPaid.value
    val userNumber: String
        get() = _userNumber.value
    val total: String
        get() = _total.value
    val date: String
        get() = _date.value
    val food: String
        get() = _food.value
    val isShowDialog: Boolean
        get() = _isShowDialog.value
    val dialogMessage: String
        get() = _dialogMessage.value
    val dialogTitle: String
        get() = _dialogTitle.value
    val noteList: StateFlow<List<Note>>
        get() = _noteList

    fun setUserPaid(userPaid: String) {
        _userPaid.value = userPaid
    }

    fun setUserNumbers(num: String) {
        try {
            _userNumber.value = num
            num.toInt()
        } catch (ex: Exception) {
            _userNumber.value = ""
            showMessageDialog("Alert dialog","Too much in users number!!!")
        }
    }

    fun setTotal(total: String) {
        try {
            _total.value = total
            total.toFloat()
        } catch (ex: Exception) {
            _total.value = "0"
            showMessageDialog("Alert dialog","Too much in total !!!")
        }
    }

    fun setFood(food: String) {
        _food.value = food
    }

    fun setDate(date: String) {
        _date.value = date
    }

    private fun checkValidData(): Boolean{
        if(_userPaid.value.isEmpty() || _date.value.isEmpty() || _food.value.isEmpty() ||
            _total.value.toFloat().equals(0f) || _userNumber.value.toInt() == 0 ){
            return false
        }
        return true
    }

    fun saveNoteToLocal(){
        try {
            if(checkValidData()){
                val note = Note(0, _userPaid.value, _date.value, _userNumber.value.toInt(), _food.value,
                    _total.value.toFloat())
                viewModelScope.launch {
                    noteRepository.createNewNoteLocal(note)
                }
                refreshInputData()
            } else {
                showMessageDialog("Alert dialog","Data input is invalid!!!")
            }
        } catch (ex: Exception){
            showMessageDialog("Exception", ex.toString())
        }
    }
    fun changeShowDialogState(){
        _isShowDialog.value = false
    }

    private fun showMessageDialog(title: String ,message: String){
        _isShowDialog.value = true
        _dialogMessage.value = message
        _dialogTitle.value = title
    }
    private fun refreshInputData(){
        _userPaid.value = ""
        _userNumber.value = ""
        _total.value = ""
        _food.value = ""
        _date.value = ""
    }
    fun readAllNotesLocal(){
        viewModelScope.launch {
            noteRepository.getAllNoteLocal().collect(){
                _noteList.value = it
                Log.e("list note", it.size.toString())
            }
        }
    }
}