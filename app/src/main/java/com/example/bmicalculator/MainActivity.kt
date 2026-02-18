package com.example.bmicalculator

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etWeight = findViewById<EditText>(R.id.etWeight)
        val etHeight = findViewById<EditText>(R.id.etHeight)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnCalculate.setOnClickListener {

            val weightText = etWeight.text.toString()
            val heightText = etHeight.text.toString()

            if (weightText.isNotEmpty() && heightText.isNotEmpty()) {

                val weight = weightText.toDouble()
                val height = heightText.toDouble()

                val bmi = weight / (height * height)

                val bmiCategory = when {
                    bmi < 18.5 -> "Underweight"
                    bmi in 18.5..24.9 -> "Normal Weight"
                    bmi in 25.0..29.9 -> "Overweight"
                    else -> "Obese"
                }

                tvResult.text = "BMI: %.2f\nCategory: %s".format(bmi, bmiCategory)

            } else {
                tvResult.text = "Please enter both weight and height"
            }
        }
    }
}
