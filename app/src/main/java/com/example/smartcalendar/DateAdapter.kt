package com.example.smartcalendar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.date_layout.view.*

class DateAdapter:
        RecyclerView.Adapter<MyViewHolder>(){

    val week = mutableListOf("Пн", "Вт", "Ср", "Чт","Пт","Сб","Вс","Пн", "Вт", "Ср", "Чт","Пт","Сб","Вс")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.date_layout, parent,  false)
        return MyViewHolder(cellForRow)
    }

    override fun getItemCount(): Int {
        return week.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val getWeekDay = week.get(position)
        holder?.view?.str_day_element?.text = getWeekDay
        holder?.view?.num_day_element?.text = position.toString()

    }



}

class MyViewHolder(val view: View): RecyclerView.ViewHolder(view){

}