package com.example.suma2num

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            var suma= et1.text.toString().toInt() + et2.text.toString().toInt()
            tv1.text = "Resultado: ${suma.toString()}"
        }
    }
}