package com.uptou.model

import androidx.room.Entity

@Entity
data class Note(
    var id: String,
    var username: String,
    var date: String,
    var userNumber: Int,
    var food: String,
    var total: Float
)