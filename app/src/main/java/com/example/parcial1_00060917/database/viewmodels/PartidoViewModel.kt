package com.example.parcial1_00060917.database.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.room.Room
import com.example.parcial1_00060917.database.RoomDB
import com.example.parcial1_00060917.database.entities.Equipo
import com.example.parcial1_00060917.database.entities.Partido
import com.example.parcial1_00060917.database.repositories.PartidoRepository

class PartidoViewModel(private val app: Application) : AndroidViewModel(app) {
    private val repository: PartidoRepository

    init {
        val equipoDao = RoomDB.getInstance(app).equipoDao()
        val partidoDao = RoomDB.getInstance(app).partidoDao()
        repository = PartidoRepository(equipoDao, partidoDao)
    }

    suspend fun insertPartidoEquipo(equipo: Equipo, partido: Partido) {
        equipo.idPartido = partido.idPartido
        repository.insertEquipo(equipo)
        repository.insertPartido(partido)
    }
}