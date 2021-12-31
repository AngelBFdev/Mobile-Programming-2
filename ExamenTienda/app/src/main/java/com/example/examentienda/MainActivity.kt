package com.example.examentienda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Ocultar la barra de acciones
        val actionBar = supportActionBar
        actionBar?.hide()

        btnEntrar.setOnClickListener {
            val intent = Intent(this, Menu::class.java)
            startActivity(intent)
        }
    }
}