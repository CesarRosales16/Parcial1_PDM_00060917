package com.example.parcial1_00060917.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.parcial1_00060917.R
import com.example.parcial1_00060917.database.dtos.PartidoDTO
import kotlinx.android.synthetic.main.activity_detalle_partido.*

class DetallePartidoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_partido)
        val partido: PartidoDTO? = intent.getBundleExtra("bundle").getParcelable("PARTIDO")
        if (partido != null) {
            iniciarComponentes(partido)
        }
    }

    private fun iniciarComponentes(partido: PartidoDTO?) {
        with(this) {
            tv_fecha.text = partido!!.fecha
            tv_equipo1.text = partido.team1
            tv_puntaje1.text = partido.team1Score
            tv_equipo2.text = partido.team2
            tv_puntaje2.text = partido.team2Score
            tv_hora.text = partido.hora
            val ganador = if (partido.team1isWinner) {
                partido.team1
            } else {
                partido.team2
            }
            if (partido.team1Score == partido.team2Score) {
                tv_ganador.text = "EMPATE"
            } else {
                tv_ganador.text = ganador
            }
        }
    }
}
