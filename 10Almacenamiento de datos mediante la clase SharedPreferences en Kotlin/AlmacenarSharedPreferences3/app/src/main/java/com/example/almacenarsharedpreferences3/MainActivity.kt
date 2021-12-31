package com.example.almacenarsharedpreferences3

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // llamar a preferencias
        //cambiar el valor de tv1 a el almacenado en preferencias
        //generar un numero random
        //al presionar el boton se tiene que hacer lo siguiente
        //si el numero es correcto se tiene que informar que ganó y el puntaje aumenta en 1
        //si es incorrecto se tiene que decir si el numero es mayor o menor al numero colocado

        val puntaje = getSharedPreferences("puntaje", Context.MODE_PRIVATE)
        var numero=(1..50).random()

        tv2.text= puntaje.getString("score","")
        if(tv2.text=="")
            tv2.text= 0.toString()
        b1.setOnClickListener{
            when {
                numero==et1.text.toString().toInt() -> {
                    Toast.makeText(this, "Has adivinado el numero.", Toast.LENGTH_LONG).show()
                    numero=(1..50).random()
                    Toast.makeText(this, "Se ha generado un nuevo numero", Toast.LENGTH_LONG).show()
                    puntaje.edit().putString("score",(tv2.text.toString().toInt()+1).toString()).commit()
                    tv2.text=puntaje.getString("score","")
                }
                numero<et1.text.toString().toInt() -> Toast.makeText(this, "El numero es menor al ingresado", Toast.LENGTH_SHORT).show()
                numero>et1.text.toString().toInt() -> Toast.makeText(this, "El numero es mayor al ingresado", Toast.LENGTH_SHORT).show()
            }
        }
    }
}