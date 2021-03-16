package com.dany.yourweighton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

// Adding a new View.OnClick and implement all members
class MainActivity : AppCompatActivity(), View.OnClickListener {

    val moonGravity = 0.165F
    val marsGravity = 0.38F
    val jupiterGravity = 2.34f


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // A toast is a view containing a quick little message for the user:
        Toast.makeText(this, "Welcome to this app!", Toast.LENGTH_LONG).show()


        buttonConvert.setOnClickListener {
            // var result = converseWeight(input.toString().toDouble())
            // resultId.text = "On the moon your weight is $result"

        }

        // I need to register the checkboxes if I want to see them in Log:

        moonCheckbox.setOnClickListener(this) // this means the class MainActivity
        marsCheckbox.setOnClickListener(this)
        jupiterCheckbox.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        v as CheckBox // Casting the CheckBox from activity_main.xml
        var isChecked: Boolean = v.isChecked
        var input = inputId.text

        when (v.id) {
            R.id.moonCheckbox -> if (isChecked && !TextUtils.isEmpty(inputId.text.toString())) {
                converseWeight(input.toString().toDouble(), v)
                marsCheckbox.isChecked = false
                jupiterCheckbox.isChecked = false
            }
            R.id.marsCheckbox -> if (isChecked && !TextUtils.isEmpty(inputId.text.toString())) {
                converseWeight(input.toString().toDouble(), v)
                moonCheckbox.isChecked = false
                jupiterCheckbox.isChecked = false
            }
            R.id.jupiterCheckbox -> if (isChecked && !TextUtils.isEmpty((inputId.text.toString()))) {
                converseWeight(input.toString().toDouble(), v)
                moonCheckbox.isChecked = false
                marsCheckbox.isChecked = false
            }
        }

        // Example: Using Log:

//        when (v.id) {
//            R.id.moonCheckbox -> if (isChecked) {
//                Log.d("Setting", "Moon")
//            } else {
//                Log.d("Uncheck", "Moon")
//            }
//            R.id.marsCheckbox -> if (isChecked) {
//                Log.d("Setting", "Mars")
//            } else {
//                Log.d("Uncheck", "Mars")
//            }
//            R.id.jupiterCheckbox -> if (isChecked) {
//                Log.d("Setting", "Jupiter")
//            } else {
//                Log.d("Uncheck", "Jupiter")
//            }
//        }
    }

    fun converseWeight(weight: Double, checkBox: CheckBox) {
        var result: Double?
        when (checkBox.id) {
            R.id.moonCheckbox -> {
                result = weight * moonGravity
                // I'm calling the function format (It's below)
                resultId.text = "On the moon your weight is ${result.format(2)}"
            }
            R.id.marsCheckbox -> {
                result = weight * marsGravity
                resultId.text = "On mars your weight is ${result.format(2)}"
            }
            R.id.jupiterCheckbox -> {
                result = weight * jupiterGravity
                resultId.text = "On jupiter your weight is ${result.format(2)}"
            }
            else -> result = weight
        }
    }

    // Function to round numbers (to 2 decimals):
    fun Double.format(digits: Int) = java.lang.String.format("%.${digits}f", this)
}
