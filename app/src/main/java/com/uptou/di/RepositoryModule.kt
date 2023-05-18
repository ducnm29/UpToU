package com.uptou.di

import com.uptou.data.db.NoteDAO
import com.uptou.repository.NoteRepository
import com.uptou.repository.NoteRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {
    @Singleton
    @Provides
    fun provideNoteRepository(noteDAO: NoteDAO): NoteRepository =
        NoteRepositoryImpl(noteDAO = noteDAO)
}