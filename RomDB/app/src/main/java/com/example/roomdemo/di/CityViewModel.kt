package com.example.roomdemo.di

import com.example.roomdemo.base.BaseViewmodel
import com.example.roomdemo.data.dao.CityDAO
import com.example.roomdemo.model.City
import kotlinx.coroutines.launch

class CityViewModel constructor(private val cityDAO: CityDAO) : BaseViewmodel() {
    fun addCity(city : City) = launch (coroutineContext){
        cityDAO.insertCompleteCity(city)
    }
}