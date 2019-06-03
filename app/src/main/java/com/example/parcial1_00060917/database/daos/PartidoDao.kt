package com.example.parcial1_00060917.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.parcial1_00060917.database.entities.Partido

@Dao
interface PartidoDao {

    @Insert
    suspend fun insertPartido(partido: Partido)

    @Query("SELECT id_partido from partido_table WHERE hora=:hora AND fecha=:fecha")
    fun getAllTeamsForMatch(hora: String, fecha: String): LiveData<Long>

    @Query("SELECT * FROM partido_table")
    fun getAllPartidos(): LiveData<List<Partido>>

    @Query("DELETE FROM partido_table")
    suspend fun deleteAll()
}