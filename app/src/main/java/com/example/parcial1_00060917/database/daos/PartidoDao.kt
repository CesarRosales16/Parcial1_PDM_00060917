package com.example.parcial1_00060917.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.parcial1_00060917.database.entities.Partido

@Dao
interface PartidoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPartido(partido: Partido)

    @Query("DELETE  FROM partido_table")
    suspend fun deleteAll()
}