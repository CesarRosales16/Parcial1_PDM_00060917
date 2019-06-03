package com.example.parcial1_00060917.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.parcial1_00060917.database.entities.Equipo

@Dao
interface EquipoDao {

    @Insert
    suspend fun insertEquipo(equipo: Equipo)

    @Query("SELECT eq.* FROM  equipo_table eq LEFT JOIN partido_table pa ON pa.id_partido=eq.fk_id_partido WHERE pa.id_partido=:idPartido")
    fun getAllEquipos(idPartido: Long): LiveData<List<Equipo>>

    @Query("DELETE FROM equipo_table")
    suspend fun deleteAll()
}