package com.example.roomdemo.dao

import androidx.room.Insert
import androidx.room.Update
import com.example.roomdemo.model.User
import com.example.roomdemo.model.UserMail
import com.example.roomdemo.model.UserName

interface UserDAO {
    @Insert
    fun insertCompleteUser(user: User)

    @Update
    fun insertOnlyNameUser(userName: UserName)

    @Update
    fun insertUserEmail(userEmail: UserMail)
}