package com.example.peticioneshttp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*

class Inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
        val actionBar = supportActionBar

        actionBar?.hide()

    }
}