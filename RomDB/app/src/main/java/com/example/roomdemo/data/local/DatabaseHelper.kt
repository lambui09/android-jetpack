package com.example.roomdemo.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomdemo.data.NoteModel

@Database(entities = arrayOf(NoteModel::class), version = 1)
abstract class DatabaseHelper : RoomDatabase(){


}