package com.example.smartcalendar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yuyakaido.android.cardstackview.CardStackListener
import com.yuyakaido.android.cardstackview.Direction
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.Year
import java.util.*
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class MainActivity : AppCompatActivity(){



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var date = Calendar.getInstance()
        singeRowCalendar.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        singeRowCalendar.adapter = DateAdapter(GetDaysList())

    }

    fun GetDaysList(): List<Calendar> {
        val daysList = mutableListOf<Calendar>()
        val date = Calendar.getInstance()
        var currentDate = date
        for( i in 1..30){
            daysList.add(currentDate)
            currentDate.add(Calendar.DAY_OF_MONTH, 1)
        }
        return daysList
    }

}
