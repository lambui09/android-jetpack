package com.example.roomdemo.data.dao

import android.graphics.Movie
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.roomdemo.model.City

@Dao
interface CityDAO {
    @Insert
    fun insertCompleteCity(city : City)

    @Query("SELECT * FROM 'cities'")
    fun getAll() : List<City>


}