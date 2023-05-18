package com.uptou.di

import android.content.Context
import com.uptou.data.db.LocalDatabase
import com.uptou.data.db.NoteDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataSourceModule {
    @Singleton
    @Provides
    fun provideLocalDatabase(@ApplicationContext context: Context) {
        LocalDatabase.getInstance(context)
    }

    @Singleton
    @Provides
    fun provideNoteDAO(localDatabase: LocalDatabase): NoteDAO =
        localDatabase.getNoteDao()
}