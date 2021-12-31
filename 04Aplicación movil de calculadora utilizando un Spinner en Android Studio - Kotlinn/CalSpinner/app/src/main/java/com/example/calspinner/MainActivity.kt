package com.example.calspinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lista = arrayOf("Sumar", "Restar", "Multiplicar", "Dividir")
        val adaptador1 = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lista)
        spinner.adapter = adaptador1

        button.setOnClickListener {
            var num1=et1.text.toString().toFloat()
            var num2=et2.text.toString().toFloat()
            when (spinner.selectedItem.toString()) {
                "Sumar" -> tv1.text = "Resultado: ${num1 + num2}"
                "Restar" -> tv1.text = "Resultado: ${num1 - num2}"
                "Multiplicar" -> tv1.text = "Resultado: ${num1 * num2}"
                "Dividir" -> tv1.text = "Resultado: ${num1 / num2}"
            }
        }
    }
}