package com.example.parcial1_00060917.database.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.parcial1_00060917.database.RoomDB
import com.example.parcial1_00060917.database.entities.Equipo
import com.example.parcial1_00060917.database.entities.Partido
import com.example.parcial1_00060917.database.repositories.PartidoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PartidoViewModel(private val app: Application) : AndroidViewModel(app) {
    private val repository: PartidoRepository

    init {
        val equipoDao = RoomDB.getInstance(app).equipoDao()
        val partidoDao = RoomDB.getInstance(app).partidoDao()
        repository = PartidoRepository(equipoDao, partidoDao)
    }

    fun insertEquipo(equipo: Equipo) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertEquipo(equipo)
    }

    fun insertarPartido(partido: Partido) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertPartido(partido)
    }

    fun getAllTeamsForMatch(hora: String, fecha: String): LiveData<Long> {
        return repository.getAllTeamsForMatch(hora, fecha)
    }

    fun getAllEquipos(idPartido: Long): LiveData<List<Equipo>> {
        return repository.getAllEquipos(idPartido)
    }

    fun getAllPartidos(): LiveData<List<Partido>> {
        return repository.getAllPartidos()
    }
}