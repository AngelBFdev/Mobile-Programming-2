package com.example.almacenartxt2

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        b1.setOnClickListener {
            val nomarchivo = etd1.text.toString().replace('/','-')
            try {
                val archivo = OutputStreamWriter(openFileOutput(nomarchivo, Activity.MODE_PRIVATE))
                archivo.write(et1.text.toString())
                archivo.flush()
                archivo.close()
            } catch (e: IOException) {
            }
            Toast.makeText(this, "Los datos fueron grabados", Toast.LENGTH_SHORT).show()
            etd1.setText("")
            et1.setText("")
        }

        b2.setOnClickListener {
            var nomarchivo = etd1.text.toString().replace('/', '-')
            if (fileList().contains(nomarchivo)) {
                try {
                    val archivo = InputStreamReader(openFileInput(nomarchivo))
                    val br = BufferedReader(archivo)
                    var linea = br.readLine()
                    val todo = StringBuilder()
                    while (linea != null) {
                        todo.append(linea + "\n")
                        linea = br.readLine()
                    }
                    br.close()
                    archivo.close()
                    et1.setText(todo)
                } catch (e: IOException) {
                }
            } else {
                Toast.makeText(this, "No hay datos grabados para dicha fecha", Toast.LENGTH_LONG).show()
                etd1.setText("")
            }
        }
    }
}