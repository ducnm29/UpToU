package com.uptou.repository

import com.uptou.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    // Remote
    suspend fun getNote(id: String): Note
    suspend fun getAllNote(): List<Note>
    suspend fun createNewNote(note: Note)
    suspend fun updateNote(note: Note)
    // Local
    suspend fun getNoteLocal(id: String): Flow<Note>
    suspend fun getAllNoteLocal(): Flow<List<Note>>
    suspend fun createNewNoteLocal(note: Note)
    suspend fun updateNoteLocal(note: Note)
}