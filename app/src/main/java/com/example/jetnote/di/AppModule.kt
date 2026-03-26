package com.example.jetnote.di

import android.content.Context
import androidx.room.Room
import com.example.jetnote.data.NoteDataBase
import com.example.jetnote.data.NoteDataBaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun providerNoteDao(noteDataBase: NoteDataBase): NoteDataBaseDao = noteDataBase.noteDao()

    @Singleton
    @Provides
    fun provideAppDataBase(@ApplicationContext context: Context): NoteDataBase =
        Room.databaseBuilder(
            context,
            NoteDataBase::class.java,
            "notes_db"
        ).fallbackToDestructiveMigration(false)
            .build()
}