package com.example.planowaniewyjazdulach

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat

class MainActivity : AppCompatActivity() {
    @SuppressLint("SimpleDateFormat", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //LINK
        setupHyperlink()

        //DECLARATIONS
        val calendar = findViewById<CalendarView>(R.id.calendarView)
        val startButton = findViewById<Button>(R.id.setTripStartButton)
        val endButton = findViewById<Button>(R.id.setTripEndButton)
        val confirmButton = findViewById<Button>(R.id.sumDateButton)
        val outputText = findViewById<TextView>(R.id.tripLengthOutput)
        var selectedDate = " "
        var selectedStartDate = " "
        var selectedEndDate = " "

        //SETTING CALENDARVIEW RANGE
        calendar.minDate = System.currentTimeMillis()
        calendar.maxDate = System.currentTimeMillis() + 63113904000 //2 years from current date

        //GET SELECTED DATE
        calendar.setOnDateChangeListener { view, year, month, day ->
            val correctMonth = month + 1
            selectedDate = "$day/$correctMonth/$year"
        }

        //START BUTTON ACTION
        startButton.setOnClickListener {
            selectedStartDate = selectedDate
            outputText.text = "Ustawiono date wyjazdu na:\n" + selectedStartDate
        }

        //END BUTTON ACTION
        endButton.setOnClickListener {
            selectedEndDate = selectedDate
            outputText.text = "Ustawiono date powrotu na:\n" + selectedEndDate
        }

        //CONFIRM BUTTON ACTION
        confirmButton.setOnClickListener {
            val mDateFormat = SimpleDateFormat("MM/dd/yyyy")

            val Date1 = mDateFormat.parse(selectedStartDate)
            val Date2 = mDateFormat.parse(selectedEndDate)
            val mDifference = kotlin.math.abs(Date1.time - Date2.time)

            val mDifferenceDates:Long
            if(Date1.time == Date2.time) {
                mDifferenceDates = 1
            }
            else if(Date1.time > Date2.time) {
                mDifferenceDates = 0
            }
            else {
                mDifferenceDates =
                    mDifference / (24 * 60 * 60 * 1000) / 31 + 2 //calculating days
            }

            val mDayDifference = mDifferenceDates.toString()
            if(mDayDifference == "0") {
                outputText.text = "Data powrotu nie moze byc szybciej od daty wyjazdu!"
            }
            else {
                outputText.text = "Długość twojego wyjazdu :\n" + mDayDifference + " dni"
            }
        }

    }

    //LINK ACTION
    private fun setupHyperlink() {
        val linkTextView = findViewById<TextView>(R.id.activity_main_link)
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance())
    }
}