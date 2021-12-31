package com.example.examentienda

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName ="productos")
class Producto(
    val nombre:String,
    val descripcion:String,
    val cantidad: Double,
    val precioCosto:Double,
    val precioVenta:Double,
    val fotoUrl:Int,
    @PrimaryKey(autoGenerate = true)
    var idProducto: Int=0
): Serializable