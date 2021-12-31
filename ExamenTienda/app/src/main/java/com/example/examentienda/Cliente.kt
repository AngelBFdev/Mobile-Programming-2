package com.example.examentienda

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName="clientes")
class Cliente (
    val nombre:String,
    val direccion:String,
    val telefono:Long,
    val email:String,
    val fotoCliente:Int,
    @PrimaryKey(autoGenerate = true)
    var idCliente:Int=0
): Serializable