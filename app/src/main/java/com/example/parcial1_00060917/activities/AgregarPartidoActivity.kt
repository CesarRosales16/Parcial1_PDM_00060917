package com.example.parcial1_00060917.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.parcial1_00060917.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_agregar_partido.*

class AgregarPartidoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_partido)
        btn_iniciar.setOnClickListener() { view ->
            if (et_equipo1.text.isNotBlank() && et_equipo2.text.isNotBlank() && et_hora.text.isNotBlank() && et_fecha.text.isNotBlank()) {

                var intent = Intent(this, PartidoActivity::class.java)
                intent.putExtra("nombre_team1", et_equipo1.text.toString())
                intent.putExtra("nombre_team2", et_equipo2.text.toString())
                intent.putExtra("hora", et_hora.text.toString())
                intent.putExtra("fecha", et_fecha.text.toString())
                startActivity(intent)
            } else {
                Snackbar.make(view, "Tiene que llenar todos los campos", Snackbar.LENGTH_LONG).show()
            }
        }
    }
}
