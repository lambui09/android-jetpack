package com.example.roomdemo.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.roomdemo.model.City

@Dao
interface CityDAO {
    @Insert
    suspend fun insertCompleteCity(city : City)

    @Query("SELECT * FROM 'cities'")
    suspend fun getAll() : List<City>

}