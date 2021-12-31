package com.example.checkboxsumres

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            var resultado=""
            var num1=et1.text.toString().toInt()
            var num2=et2.text.toString().toInt()
            if (cb1.isChecked)
                resultado = "Suma = ${ num1 + num2} \n"
            if (cb2.isChecked)
                resultado += "Resta = ${num1 - num2}"
            tv1.text = resultado
        }
    }
}