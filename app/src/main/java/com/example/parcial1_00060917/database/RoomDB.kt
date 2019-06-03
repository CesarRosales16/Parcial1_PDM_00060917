package com.example.parcial1_00060917.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.parcial1_00060917.database.daos.EquipoDao
import com.example.parcial1_00060917.database.daos.PartidoDao
import com.example.parcial1_00060917.database.entities.Equipo
import com.example.parcial1_00060917.database.entities.Partido

@Database(entities = [Equipo::class,Partido::class], version = 1, exportSchema = false)
public abstract class RoomDB : RoomDatabase() {

    abstract fun equipoDao(): EquipoDao
    abstract fun partidoDao(): PartidoDao

    companion object {
        @Volatile
        private var INSTANCE: RoomDB? = null

        fun getInstance(
            context: Context
        ): RoomDB {
            if (INSTANCE != null) {
                return INSTANCE!!
            } else {
                synchronized(this) {
                    INSTANCE = Room
                        .databaseBuilder(context, RoomDB::class.java, "Partido_Database")
                        .build()
                    return INSTANCE!!
                }
            }
        }
    }
}