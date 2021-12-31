package com.example.examentienda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Ventas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ventas)

        //Ocultar la barra de acciones
        val actionBar = supportActionBar
        actionBar?.hide()
    }
}