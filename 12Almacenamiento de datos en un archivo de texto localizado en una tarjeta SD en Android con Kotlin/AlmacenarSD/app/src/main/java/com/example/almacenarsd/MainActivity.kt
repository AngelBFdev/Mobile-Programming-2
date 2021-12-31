package com.example.almacenarsd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        b1.setOnClickListener {
            try {
                val tarjeta = Environment.getExternalStorageDirectory()
                val file = File(tarjeta.getAbsolutePath(), et1.text.toString())
                val osw = OutputStreamWriter(FileOutputStream(file))
                osw.write(et2.text.toString())
                osw.flush()
                osw.close()
                Toast.makeText(this, "Los datos fueron grabados correctamente", Toast.LENGTH_SHORT).show()
                et1.setText("")
                et2.setText("")
            } catch (ioe: IOException) {
                Toast.makeText(this, "No se pudo grabar", Toast.LENGTH_SHORT).show()
            }
        }

        b2.setOnClickListener {
            val tarjeta = Environment.getExternalStorageDirectory()
            val file = File(tarjeta.absolutePath, et1.text.toString())
            try {
                val fIn = FileInputStream(file)
                val archivo = InputStreamReader(fIn)
                val br = BufferedReader(archivo)
                var linea = br.readLine()
                val todo = StringBuilder()
                while (linea != null) {
                    todo.append(linea + "\n")
                    linea = br.readLine()
                }
                br.close()
                archivo.close()
                et2.setText(todo)

            } catch (e: IOException) {
                Toast.makeText(this, "No se pudo leer", Toast.LENGTH_SHORT).show()
            }
        }
    }
}