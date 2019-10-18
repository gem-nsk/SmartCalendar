package com.example.smartcalendar

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.date_layout.view.*
import java.util.*

class DateAdapter(val dateList: List<Calendar>, val currentDate: String):
        RecyclerView.Adapter<MyViewHolder>(){

    val week = mutableListOf("Пн", "Вт", "Ср", "Чт","Пт","Сб","Вс","Пн", "Вт", "Ср", "Чт","Пт","Сб","Вс")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.date_layout, parent,  false)
        return MyViewHolder(cellForRow)
    }

    override fun getItemCount(): Int {
        return dateList.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        if(currentDate == dateList[position].get(Calendar.DATE).toString()){
            holder?.view?.str_day_element?.setTextColor(Color.WHITE)
            holder?.view?.num_day_element?.setTextColor(Color.WHITE)

            holder?.view?.str_day_element?.setBackgroundColor(ContextCompat.getColor(holder.view.context,R.color.blue800))
            holder?.view?.num_day_element?.setBackgroundColor(ContextCompat.getColor(holder.view.context,R.color.blue800))

        }
        else{
            holder?.view?.str_day_element?.setTextColor(ContextCompat.getColor(holder.view.context,R.color.gray700))
            holder?.view?.num_day_element?.setTextColor(ContextCompat.getColor(holder.view.context,R.color.gray700))

            holder?.view?.str_day_element?.setBackgroundColor(Color.WHITE)
            holder?.view?.num_day_element?.setBackgroundColor(Color.WHITE)
        }
            val dayOfWeekInMonth: Int = dateList[position].get(Calendar.DAY_OF_WEEK)
            var dayOfWeekInMonthStr = ""
            when(dayOfWeekInMonth-1) {
                1 -> dayOfWeekInMonthStr = "Пн"
                2 -> dayOfWeekInMonthStr = "Вт"
                3 -> dayOfWeekInMonthStr = "Ср"
                4 -> dayOfWeekInMonthStr = "Чт"
                5 -> dayOfWeekInMonthStr = "Пт"
                6 -> dayOfWeekInMonthStr = "Сб"
                0 -> dayOfWeekInMonthStr = "Вс"
            }
            holder?.view?.str_day_element?.text = dayOfWeekInMonthStr
            holder?.view?.num_day_element?.text = dateList[position].get(Calendar.DATE).toString()

    }
}

class MyViewHolder(val view: View): RecyclerView.ViewHolder(view){

}