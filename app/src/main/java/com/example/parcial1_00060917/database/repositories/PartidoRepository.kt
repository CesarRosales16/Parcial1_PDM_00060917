package com.example.parcial1_00060917.database.repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.parcial1_00060917.database.daos.EquipoDao
import com.example.parcial1_00060917.database.daos.PartidoDao
import com.example.parcial1_00060917.database.entities.Equipo
import com.example.parcial1_00060917.database.entities.Partido

class PartidoRepository(private val equipoDao: EquipoDao, private val partidoDao: PartidoDao) {

    @WorkerThread
    suspend fun insertEquipo(equipo: Equipo) {
        equipoDao.insertEquipo(equipo)
    }

    @WorkerThread
    suspend fun insertPartido(partido: Partido) {
        partidoDao.insertPartido(partido)
    }

    fun getAllTeamsForMatch(hora: String, fecha: String): LiveData<Long> {
        return partidoDao.getAllTeamsForMatch(hora, fecha)
    }

    fun getAllEquipos(idPartido: Long): LiveData<List<Equipo>> {
        return equipoDao.getAllEquipos(idPartido)
    }

    fun getAllPartidos(): LiveData<List<Partido>> {
        return partidoDao.getAllPartidos()
    }
}