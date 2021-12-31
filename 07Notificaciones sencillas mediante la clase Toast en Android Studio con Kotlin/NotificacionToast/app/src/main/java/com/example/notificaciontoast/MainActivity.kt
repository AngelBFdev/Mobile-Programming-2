package com.example.notificaciontoast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var numero = (0..10).random()
        Toast.makeText(this, "Número a recordar: ${numero}", Toast.LENGTH_LONG).show()
        b1.setOnClickListener {
            if (numero == et1.text.toString().toInt())
                Toast.makeText(this, "Muy bien recordaste el número mostrado.", Toast.LENGTH_LONG).show()
            else
                Toast.makeText(this, "Lo siento pero no es el número mostrado.", Toast.LENGTH_LONG).show()
        }
        b2.setOnClickListener {
            numero = (0..10).random()
            Toast.makeText(this, "Número a recordar: ${numero}", Toast.LENGTH_LONG).show()
        }
    }
}