package com.example.examentienda

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface ProductosDao {
    @Query("SELECT * FROM productos")
    fun getAll(): LiveData<List<Producto>>

    @Query("SELECT * FROM productos WHERE idProducto = :id")
    fun getById(id: Int): LiveData<Producto>

    @Insert
    fun insertAll(vararg productos: Producto)

    @Update
    fun update(producto: Producto)

    @Delete
    fun delete(producto: Producto)

}