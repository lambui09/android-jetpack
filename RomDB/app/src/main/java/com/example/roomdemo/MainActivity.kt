package com.example.roomdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdemo.data.local.AppDatabase
import com.example.roomdemo.data.local.AppDatabaseHelper
import com.example.roomdemo.model.City
import com.example.roomdemo.ui.CityAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var listCity : ArrayList<City>
    private lateinit var cityAdapter: CityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initAdapter()
        getCity()
    }

    private fun initAdapter(){
        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.adapter = CityAdapter(this, listCity)
    }

    private fun getCity(){
        this.let {
            AppDatabaseHelper.getInstance(this)
        }
    }
}
