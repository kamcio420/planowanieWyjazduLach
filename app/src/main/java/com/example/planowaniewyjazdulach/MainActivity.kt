package com.example.planowaniewyjazdulach

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
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

    }

    //LINK ACTION
    private fun setupHyperlink() {
        val linkTextView = findViewById<TextView>(R.id.activity_main_link)
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance())
    }
}