package com.example.parcial1_00060917.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "partido_table")
data class Partido(
    @ColumnInfo(name = "hora")
    val hora: String,
    @ColumnInfo(name = "fecha")
    val fecha: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_partido")
    var idPartido: Long = 0
}