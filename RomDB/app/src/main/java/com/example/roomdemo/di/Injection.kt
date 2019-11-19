package com.example.roomdemo.di

import android.content.Context
import com.example.roomdemo.data.dao.CityDAO
import com.example.roomdemo.data.local.AppDatabase

object Injection {
    private fun provideCityDataSource(context: Context) : CityDAO{
        val database = AppDatabase.getInstance(context)
        return database!!.cityDao()
    }
    private fun provideViewmodelFactory(context: Context) : ViewMode
}