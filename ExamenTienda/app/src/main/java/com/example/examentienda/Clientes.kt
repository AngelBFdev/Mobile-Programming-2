package com.example.examentienda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_clientes.*

class Clientes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clientes)

        //Ocultar la barra de acciones
        val actionBar = supportActionBar
        actionBar?.hide()

        var listaClientes= emptyList<Cliente>()
        val database=AppDataBaseClientes.getDatabase(this)

        database.clientes().getAll().observe(this, Observer{
            listaClientes=it

            val adapter=ClientesAdapter(this,listaClientes)

            lista.adapter=adapter

        })



        lista.setOnItemClickListener{parent, view, position, id->
            val intent= Intent(this, ClienteActivity::class.java)
            intent.putExtra("id", listaClientes[position].idCliente)
            startActivity(intent)
        }

        floatingActionButton.setOnClickListener{
            val intent= Intent(this, NuevoClienteActivity::class.java)
            startActivity((intent))
        }
    }
}