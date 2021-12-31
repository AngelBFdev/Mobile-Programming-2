package com.example.almacenarsharedpreferences2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val preferencias = getSharedPreferences("agenda", Context.MODE_PRIVATE)
        b1.setOnClickListener{
            val editor = preferencias.edit()
            editor.putString(et1.text.toString(), et2.text.toString())
            editor.commit()
            Toast.makeText(this, "Datos grabados", Toast.LENGTH_LONG).show()
            et1.setText("")
            et2.setText("")
        }
        b2.setOnClickListener {
            val datos = preferencias.getString(et1.text.toString(), "")
            if (datos.isNullOrEmpty())
                Toast.makeText(this, "No existe dicho nombre en la agenda", Toast.LENGTH_LONG).show()
            else
                et2.setText(datos)
        }
    }
}