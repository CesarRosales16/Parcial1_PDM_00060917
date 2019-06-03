package com.example.parcial1_00060917.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(
        tableName = "equipo_table",
        foreignKeys = [ForeignKey(
                entity = Partido::class,
                parentColumns = ["id_partido"],
                childColumns = ["fk_id_partido"],
                onDelete = CASCADE
        )]
)
data class Equipo(
        @ColumnInfo(name = "name") val nombre: String,
        @ColumnInfo(name = "puntaje") val puntaje: String,
        @ColumnInfo(name = "is_winner") val isWinner: Boolean,
        @ColumnInfo(name = "fk_id_partido") var idPartido: Long?
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_equipo")
    var idEquipo: Long = 0
}