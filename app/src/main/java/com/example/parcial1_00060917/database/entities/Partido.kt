package com.example.parcial1_00060917.database.entities

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "partido_table")
data class Partido(
        @ColumnInfo(name = "hora")
        val hora: String,
        @ColumnInfo(name = "fecha")
        val fecha: String
) : Parcelable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_partido")
    var idPartido: Long = 0

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString()) {
        idPartido = parcel.readLong()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(hora)
        parcel.writeString(fecha)
        parcel.writeLong(idPartido)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Partido> {
        override fun createFromParcel(parcel: Parcel): Partido {
            return Partido(parcel)
        }

        override fun newArray(size: Int): Array<Partido?> {
            return arrayOfNulls(size)
        }
    }
}