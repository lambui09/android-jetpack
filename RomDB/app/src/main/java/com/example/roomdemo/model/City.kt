package com.example.roomdemo.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cities")
data class City(
 @PrimaryKey(autoGenerate = true) var id : String? = null,
 val country : String? = null,
 val city : String? = null,
 val population : Long? = null
 )