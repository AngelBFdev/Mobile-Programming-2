package com.example.examentienda

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Producto::class], version = 1)
abstract class
TiendaDb : RoomDatabase() {

    // Tabla Productos
    abstract fun productos(): ProductosDao

    companion object{
        @Volatile
        private var INSTANCE: TiendaDb? = null

        fun getDatabase(context: Context): TiendaDb{
            val tempInstance = INSTANCE

            if(tempInstance != null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TiendaDb::class.java,
                    "tienda_db"
                ).build()

                INSTANCE = instance

                return instance
            }
        }
    }
}