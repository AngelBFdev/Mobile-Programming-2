package com.example.examentienda

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Cliente::class], version=1)
abstract class AppDataBaseClientes : RoomDatabase(){

    abstract fun clientes():ClientesDao

    companion object{
        @Volatile
        private var INSTANCE:AppDataBaseClientes?=null

        fun getDatabase(context: Context):AppDataBaseClientes{
            val tempInstance= INSTANCE

            if(tempInstance!=null){
                return tempInstance
            }

            synchronized(this){
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBaseClientes::class.java,
                    "app_database_clientes"
                ).build()

                INSTANCE=instance

                return instance
            }
        }
    }
}