package com.example.roomdemo.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdemo.R
import com.example.roomdemo.model.City
import kotlinx.android.synthetic.main.item_vetical_viewholder.view.*

class CityAdapter(val context: Context,val listCity : ArrayList<City>) : RecyclerView.Adapter<CityAdapter.CityViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_vetical_viewholder, parent, false)
        return CityViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listCity.size

    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val city = listCity[position]
        holder.itemView.tvCity.text = city.city.toString()
        holder.itemView.tvCountry.text = city.country.toString()
        holder.itemView.tvPopulation.text = city.population.toString()
    }
    class CityViewHolder(view : View) : RecyclerView.ViewHolder(view){
        init {

        }
    }
}