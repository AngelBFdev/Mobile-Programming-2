package com.example.almacenarsharedpreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE)
        etmail1.setText(preferencias.getString("mail", ""))
        b1.setOnClickListener {
            val editor = preferencias.edit()
            editor.putString("mail", etmail1.text.toString())
            editor.commit()
            finish()
        }
    }
}