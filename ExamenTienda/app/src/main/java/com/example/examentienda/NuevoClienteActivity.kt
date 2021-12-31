package com.example.examentienda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_nuevo_cliente.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NuevoClienteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevo_cliente)

        var idCliente:Int?=null

        if(intent.hasExtra("cliente")){
            val cliente=intent.extras?.getSerializable("cliente") as Cliente

            nombre_et.setText(cliente.nombre)
            direccion_et.setText(cliente.direccion)
            telefono_et.setText(cliente.telefono.toString())
            email_et.setText(cliente.email)
            idCliente=cliente.idCliente




        }

        val database=AppDataBaseClientes.getDatabase(this)

        save_btn.setOnClickListener{
            val nombre=nombre_et.text.toString()
            val telefono=telefono_et.text.toString().toLong()
            val email=email_et.text.toString()
            val direccion=direccion_et.text.toString()

            val cliente=Cliente(nombre, direccion, telefono, email, R.drawable.dos)

            if(idCliente!=null){
                CoroutineScope(Dispatchers.IO).launch {
                    cliente.idCliente=idCliente

                    database.clientes().update(cliente)

                    this@NuevoClienteActivity.finish()
                }
            }else{
                CoroutineScope(Dispatchers.IO).launch{
                    database.clientes().insertAll(cliente)

                    this@NuevoClienteActivity.finish()
                }
            }

        }
    }
}