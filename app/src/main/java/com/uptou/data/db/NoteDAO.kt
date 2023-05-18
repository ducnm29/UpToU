package com.uptou.data.db

import androidx.room.Dao
import androidx.room.Query
import com.uptou.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDAO : BaseDAO<Note> {
    @Query("SELECT * FROM note WHERE id = :id")
    fun getNote(id: String): Flow<Note>

    @Query("SELECT * FROM note")
    fun getAllNote(): Flow<List<Note>>

}