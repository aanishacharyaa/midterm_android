package com.anish.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.anish.CONVERSIONAPP.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // Array of units for user to select from
    val units =
        arrayOf(
            "Kilometers",
            "Centimeters",
            "Feet",
            "Miles",
            "Millimeters",
            "Micrometers",
            "Inches",
            "Yards"
        )

    val conversionFactors = arrayOf(
        // 1 to 1, 2, 3, 4, 5, 6, 7, 8
        arrayOf(1.0, 100000.0, 3280.8, 0.621371, 1000000.0, 1000000000.0, 39370.1, 1093.61),
        // 2 to 1, 2, 3, 4, 5, 6, 7, 8
        arrayOf(0.00001, 1.0, 0.003048, 0.00000621371, 0.1, 100.0, 0.0254, 0.0009144),
        // 3 to 1, 2, 3, 4, 5, 6, 7, 8
        arrayOf(0.0003048, 30.48, 1.0, 0.0003048, 304.8, 304800.0, 12.0, 3.0),
        // 4 to 1, 2, 3, 4, 5, 6, 7, 8
        arrayOf(1.60934, 160934.0, 5280.0, 1.0, 1609344.0, 1609000000.0, 63360.0, 1760.0),
        // 5 to 1, 2, 3, 4, 5, 6, 7, 8
        arrayOf(0.000001, 10.0, 0.0030480, 0.000000621371, 1.0, 1000.0, 0.0254, 0.0009144),
        // 6 to 1, 2, 3, 4, 5, 6, 7, 8
        arrayOf(0.000000001, 10000.0, 0.0003048, 0.00000000621371, 0.001, 1.0, 0.0000254, 0.0000009144),
        // 7 to 1, 2, 3, 4, 5, 6, 7, 8
        arrayOf(0.0000254, 254.0, 0.083333, 0.0000157828, 2.54, 25400.0, 1.0, 0.0277778),
        // 8 to 1, 2, 3, 4, 5, 6, 7, 8
        arrayOf(0.0009144, 9144.0, 3.0, 0.000568182, 914.4, 914400.0, 36.0, 1.0)
    )

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, units)
        binding.selectSourceSp1.adapter = adapter
        binding.selectDestSp2.adapter = adapter

        binding.selectSourceSp1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

        binding.selectDestSp2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

        binding.calcBtn.setOnClickListener {
            val inputUnit = binding.selectSourceSp1.selectedItemPosition
            val outputUnit = binding.selectDestSp2.selectedItemPosition
            val inputValue = binding.etAmount.text.toString().toDouble()
            val result = inputValue * conversionFactors[inputUnit ][outputUnit]
            binding.tvAns.setText(result.toString())
        }


    }
}