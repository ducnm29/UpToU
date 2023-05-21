package com.uptou.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    @PrimaryKey var id: String,
    var username: String,
    var date: String,
    var userNumber: Int,
    var food: String,
    var total: Float
)