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
    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupHyperlink()

        //DECLARATIONS
        val calendar = findViewById<CalendarView>(R.id.calendarView)
        val startButton = findViewById<Button>(R.id.setTripStartButton)
        val endButton = findViewById<Button>(R.id.setTripEndButton)
        val confirmButton = findViewById<Button>(R.id.sumDateButton)
        val outputText = findViewById<TextView>(R.id.tripLengthOutput)

        //GET CURRENT DATE
        val pattern = SimpleDateFormat("dd/MM/yyyy")

        calendar.minDate = System.currentTimeMillis()
        calendar.maxDate = System.currentTimeMillis() + 63113904000 //2 years from current date

        //START BUTTON ACTION
        startButton.setOnClickListener {
            var formatedStartDate = pattern.format(calendar.date)
            outputText.text = "Ustawiono date wyjazdu na:\n" + formatedStartDate
        }

        //END BUTTON ACTION
        endButton.setOnClickListener {
            var formatedEndDate = pattern.format(calendar.date)
            outputText.text = "Ustawiono date przyjazdu na:\n" + formatedEndDate
        }

        //CONFIRM BUTTON ACTION
        confirmButton.setOnClickListener {
            var sumDate = " "
            outputText.text = "Długość twojego wyjazdu :\n" + sumDate
        }

    }

    //LINK ACTION
    private fun setupHyperlink() {
        val linkTextView = findViewById<TextView>(R.id.activity_main_link)
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance())
    }
}