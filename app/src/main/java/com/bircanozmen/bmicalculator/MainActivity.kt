package com.bircanozmen.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bircanozmen.bmicalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.heightPicker.minValue=150
        binding.heightPicker.maxValue=250

        binding.weightPicker.minValue=45
        binding.weightPicker.maxValue=250

        binding.weightPicker.setOnValueChangedListener{ _,_,_ ->
            calculateBMI()
        }

        binding.heightPicker.setOnValueChangedListener{_,_,_ ->

            calculateBMI()
        }

    }

    private fun calculateBMI()
    {
        val height = binding.heightPicker.value
        val doubleHeight = height.toDouble() / 100

        val weight = binding.weightPicker.value

        val bmi = weight.toDouble() / (doubleHeight * doubleHeight)

        binding.resultText.text = String.format("Your BMI is %.2f", bmi)
        binding.healthText.text = String.format("Considered: %s", healthyMessage(bmi))

    }

    private fun healthyMessage(bmi: Double): String
    {
        if (bmi < 18.5)
            return "Underweight"
        if(bmi < 25.0)
            return "Healthy"
        if (bmi < 30.0)
            return "Overweight"

        return "Obese"
    }


    }
