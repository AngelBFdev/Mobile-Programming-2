package com.example.examentienda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ComputableLiveData
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
//import com.example.ventas.TiendaDb
import kotlinx.android.synthetic.main.activity_producto.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductoActivity : AppCompatActivity() {

    private lateinit var  database: TiendaDb
    private lateinit var producto: Producto
    private lateinit var productoLiveData: LiveData<Producto>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto)

        database=TiendaDb.getDatabase(this)

        val idProducto= intent.getIntExtra("id", 0)

        productoLiveData=database.productos().getById(idProducto)
        productoLiveData.observe(this, Observer{
            producto=it

            nombre_producto.text = producto.nombre
            descripcion_producto.text= producto.descripcion
            cantidad_producto.text= producto.cantidad.toString()
            preciocosto_producto.text ="$${producto.precioCosto}"
            precioventa_producto.text="$${producto.precioVenta}"
            fotoUrl.setImageResource(producto.fotoUrl)
        })



    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.producto_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.edit_item->
            {
                val intent = Intent(this, NuevoProductoActivity::class.java)
                intent.putExtra("producto", producto)
                startActivity(intent)
            }
            R.id.delete_item->
            {
                productoLiveData.removeObservers(this)

                CoroutineScope(Dispatchers.IO).launch {
                    database.productos().delete(producto)
                    this@ProductoActivity.finish()
                }
            }
        }
        return super.onOptionsItemSelected(item)

    }
}