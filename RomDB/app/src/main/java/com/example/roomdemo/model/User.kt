package com.example.roomdemo.model

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class User(
    @PrimaryKey val id : Long,
    val name : String,
    val email : String
)
data class UserName(val id: Long, val name: String)
data class UserMail(val id: Long, val email: String)