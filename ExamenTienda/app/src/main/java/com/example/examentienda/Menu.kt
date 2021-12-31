package com.example.examentienda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu.*

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        //Ocultar la barra de acciones
        val actionBar = supportActionBar
        actionBar?.hide()

       btnProductos.setOnClickListener {
           val intent = Intent(this, Productos::class.java)
           startActivity(intent)
       }
        btnClientes.setOnClickListener {
            val intent = Intent(this, Clientes::class.java)
            startActivity(intent)
        }

        btnMenu.setOnClickListener {
            val intent = Intent(this, Ventas::class.java)
            startActivity(intent)
        }
    }
}