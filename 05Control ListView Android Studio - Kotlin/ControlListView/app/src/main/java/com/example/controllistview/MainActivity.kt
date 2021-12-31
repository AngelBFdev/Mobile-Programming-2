package com.example.controllistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val paises = arrayOf( "Argentina", "Chile", "Paraguay", "Bolivia", "Peru", "Ecuador", "Brasil", "Colombia", "Venezuela", "Uruguay")
        var habitantes = arrayOf("40,000,000", "17,000,000", "6,500,000", "10,000,000", "30,000,000", "14,000,000", "183,000,000", "44,000,000", "31,000,000", "3,500,000")
        val adaptador1 = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, paises)
        lv1.adapter = adaptador1
        lv1.setOnItemClickListener {
            adapterView, view, i, l -> tv1.text = "Población de ${paises[i]}: ${habitantes[i]}"
        }
    }
}