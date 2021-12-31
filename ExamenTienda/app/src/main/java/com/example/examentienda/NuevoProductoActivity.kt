package com.example.examentienda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import com.example.ventas.TiendaDb
import kotlinx.android.synthetic.main.activity_nuevo_producto.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NuevoProductoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevo_producto)

        var idProducto: Int? = null

        if(intent.hasExtra("producto")){
            val producto = intent.extras?.getSerializable("producto") as Producto

            nombre_et.setText(producto.nombre)
            descripcion_et.setText(producto.descripcion)
            cantidad_et.setText(producto.cantidad.toString())
            preciocosto_et.setText(producto.precioCosto.toString())
            precioventa_et.setText(producto.precioVenta.toString())
            idProducto=producto.idProducto
        }

        val database=TiendaDb.getDatabase(this)

        save_btn.setOnClickListener {
            val nombre= nombre_et.text.toString()
            val descripcion= descripcion_et.text.toString()
            val cantidad= cantidad_et.text.toString().toDouble()
            val preciocosto= preciocosto_et.text.toString().toDouble()
            val precioventa= precioventa_et.text.toString().toDouble()

            val producto=Producto(nombre, descripcion, cantidad, preciocosto, precioventa, R.drawable.producto)

            if (idProducto !=null){
                CoroutineScope(Dispatchers.IO).launch {
                    producto.idProducto=idProducto

                    database.productos().update(producto)

                    this@NuevoProductoActivity.finish()
                }
            } else
            {
                CoroutineScope(Dispatchers.IO).launch {
                    database.productos().insertAll(producto)

                    this@NuevoProductoActivity.finish()
                }
            }


        }

    }
}