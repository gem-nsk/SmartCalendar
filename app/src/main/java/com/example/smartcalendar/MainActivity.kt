package com.example.smartcalendar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity(){



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



//        инициализируем маленький календарь
        InitLittleCalendar()
        SetCurrentMontAndYeat()
    }

    fun SetCurrentMontAndYeat(){
        val c = Calendar.getInstance()
        val currentMonth = c.get(Calendar.MONTH)
        val currentYear = c.get(Calendar.YEAR)

        var currentMonthStr = ""
        when(currentMonth){
            0 -> currentMonthStr = "Январь"
            1 -> currentMonthStr = "Февраль"
            2 -> currentMonthStr = "Март"
            3 -> currentMonthStr = "Апрель"
            4 -> currentMonthStr = "Май"
            5 -> currentMonthStr = "Июнь"
            6 -> currentMonthStr = "Июль"
            7 -> currentMonthStr = "Август"
            8 -> currentMonthStr = "Сентябрь"
            9 -> currentMonthStr = "Октябрь"
            10 -> currentMonthStr = "Ноябрь"
            11 -> currentMonthStr = "Декабрь"
        }
        val str = "$currentMonthStr $currentYear"
        currentMonth_tv.setText(str)
    }

    fun InitLittleCalendar(){
        var date = Calendar.getInstance()
        val numDay = date.get(Calendar.DATE).toString()
        singeRowCalendar.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        singeRowCalendar.adapter = DateAdapter(GetDaysList(), numDay)
        singeRowCalendar.addOnScrollListener(CustomScrollListener())
    }

    fun GetDaysList(): List<Calendar> {

        val readOnlyView =  mutableListOf<Calendar>()
        val calendar = Calendar.getInstance()
        val days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        var index = 0
        while(index < days){
            readOnlyView += getDaysAgo(index)
            index++
        }
        return readOnlyView
    }

    fun getDaysAgo(daysAgo: Int): Calendar {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.DAY_OF_MONTH, 1)
        calendar.add(Calendar.DAY_OF_MONTH, +daysAgo)

        return calendar
    }



}
