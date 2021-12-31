package com.example.examentienda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_productos.*


class Productos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)

        //Ocultar la barra de acciones
        val actionBar = supportActionBar
        actionBar?.hide()

        var listaProductos= emptyList<Producto>()
        val database=TiendaDb.getDatabase(this)

        database.productos().getAll().observe(this, Observer {
            listaProductos =it

            val adapter= ProductoAdapter(this, listaProductos)
            lista.adapter = adapter

        })


        lista.setOnItemClickListener { parent, view, position, id ->
            val intent= Intent(this, ProductoActivity::class.java)
            intent.putExtra("id" , listaProductos[position].idProducto)
            startActivity(intent)

        }

        botondecompras.setOnClickListener {
            val intent= Intent(this, NuevoProductoActivity::class.java)
            startActivity(intent)
        }

    }
}