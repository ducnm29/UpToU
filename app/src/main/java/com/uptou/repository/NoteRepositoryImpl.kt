package com.uptou.repository

import com.uptou.data.db.NoteDAO
import com.uptou.model.Note
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val noteDAO: NoteDAO
) : NoteRepository {
    // Remote
    override suspend fun getNote(id: String): Note {
        TODO("Not yet implemented")
    }

    override suspend fun getAllNote(): List<Note> {
        TODO("Not yet implemented")
    }

    override suspend fun createNewNote(note: Note) {
        TODO("Not yet implemented")
    }

    override suspend fun updateNote(note: Note) {
        TODO("Not yet implemented")
    }

    // Local
    override suspend fun getNoteLocal(id: String): Flow<Note> {
        return noteDAO.getNote(id)
    }

    override fun getAllNoteLocal(): Flow<List<Note>> {
        return noteDAO.getAllNote()
    }

    override suspend fun createNewNoteLocal(note: Note) {
        noteDAO.insert(note)
    }

    override suspend fun updateNoteLocal(note: Note) {
        noteDAO.update(note)
    }

}