package com.uptou.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    @PrimaryKey(autoGenerate = true)  var id: Long ,
    var username: String,
    var date: String,
    var userNumber: Int,
    var food: String,
    var total: Float
)