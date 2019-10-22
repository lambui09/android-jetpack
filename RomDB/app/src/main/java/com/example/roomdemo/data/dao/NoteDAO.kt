package com.example.roomdemo.data.dao

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.roomdemo.data.NoteModel

@Dao
interface NoteDAO {
    @Insert
    fun insertNote(note: NoteModel)

    @Query("select * from note_table Order by created_at")
    fun fetchAllTasks(): LiveData<List<NoteModel>>

    @Update
    fun updateTask(note: NoteModel)

    @Delete
    fun deleteTask(note: NoteModel)
}