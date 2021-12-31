package com.example.radiosumres

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            var num1=et1.text.toString().toInt()
            var num2=et2.text.toString().toInt()

            if (rb1.isChecked)
                tv1.text = "Resultado: ${num1 + num2}"
            if (rb2.isChecked)
                tv1.text = "Resultado: ${num1 - num2}"
        }

    }
}