package com.example.smartcalendar

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.date_layout.view.*
import java.util.*

class DateAdapter(val dateList: List<Calendar>):
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
//        val getWeekDay = week.get(position)
//        holder?.view?.str_day_element?.text = getWeekDay
//        holder?.view?.num_day_element?.text = position.toString()
        var flg = false
        for(date in dateList){
            val dayOfWeekInMonth: Int = date.get(Calendar.DAY_OF_WEEK_IN_MONTH)
            var dayOfWeekInMonthStr: String = ""
            when(dayOfWeekInMonth) {
                0 -> dayOfWeekInMonthStr = "Пн"
                1 -> dayOfWeekInMonthStr = "Вт"
                2 -> dayOfWeekInMonthStr = "Ср"
                3 -> dayOfWeekInMonthStr = "Чт"
                4 -> dayOfWeekInMonthStr = "Пт"
                5 -> dayOfWeekInMonthStr = "Сб"
                6 -> dayOfWeekInMonthStr = "Вс"
            }
            holder?.view?.str_day_element?.text = dayOfWeekInMonthStr
            holder?.view?.num_day_element?.text = date.get(Calendar.DATE).toString()
            if(flg == false){
                holder?.view?.str_day_element?.setTextColor(Color.BLUE)
                holder?.view?.num_day_element?.setTextColor(Color.BLUE)
                flg = true
            }
            else{
                holder?.view?.str_day_element?.setTextColor(Color.BLUE)
                holder?.view?.num_day_element?.setTextColor(Color.BLUE)
            }
        }



    }
}

class MyViewHolder(val view: View): RecyclerView.ViewHolder(view){

}