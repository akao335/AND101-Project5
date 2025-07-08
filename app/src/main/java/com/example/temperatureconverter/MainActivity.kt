package com.example.temperatureconverter

import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val button1 = findViewById<Button>(R.id.button1)
        val fahrenheitInput = findViewById<TextInputEditText>(R.id.fahrenheitInput)
        val celsiusResult = findViewById<TextView>(R.id.celsiusResult)

        button1.setOnClickListener {
            val inputText = fahrenheitInput.text?.toString()
            if (!inputText.isNullOrEmpty()) {
                val fahrenheit = inputText.toDoubleOrNull()
                if (fahrenheit != null) {
                    val celsius = (fahrenheit - 32) * 5 / 9
                    celsiusResult.text = "%.2f".format(celsius)
                } else {
                    celsiusResult.text = "Invalid input"
                }
            } else {
                celsiusResult.text = "Please enter a temperature"
            }
        }
    }
}
