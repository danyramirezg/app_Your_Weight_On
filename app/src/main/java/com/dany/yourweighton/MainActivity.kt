package com.dany.yourweighton

import android.media.tv.TvContract
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val weightMoon = 0.165F

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var input = inputId.text

        buttonConvert.setOnClickListener {
            var result = converseWeight(input.toString().toDouble())
            resultId.text = "On the moon your weight is $result"
        }
    }

    fun converseWeight(weight: Double): Double {
        return weight * weightMoon
    }
}
