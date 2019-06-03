package com.example.parcial1_00060917.activities

import android.content.Intent
import android.os.Bundle
import android.provider.Telephony
import android.util.Log
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parcial1_00060917.R
import com.example.parcial1_00060917.adapters.PartidoAdapter
import com.example.parcial1_00060917.database.dtos.PartidoDTO
import com.example.parcial1_00060917.database.viewmodels.PartidoViewModel

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var listaDTO: ArrayList<PartidoDTO> = ArrayList()
    lateinit var partidoAdapter: PartidoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModelPartidoEquipo = ViewModelProviders.of(this).get(PartidoViewModel::class.java)
        partidoAdapter = PartidoAdapter(this, {partido:PartidoDTO-> iniciarActivityPartido(partido)})
        rvPartidos.apply {
            adapter = partidoAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
        viewModelPartidoEquipo.getAllPartidos().observe(this, Observer { listaPartidos ->
            if (listaPartidos.size != 0) {
                listaDTO.clear()
                listaPartidos.forEach { partido ->
                    viewModelPartidoEquipo.getAllEquipos(partido.idPartido).observe(this@MainActivity, Observer { listaEquipos ->
                        if (listaEquipos.size >= 2) {
                            listaDTO.add(PartidoDTO(partido.hora, partido.fecha, listaEquipos[0].nombre, listaEquipos[1].nombre, listaEquipos[0].isWinner, listaEquipos[0].puntaje, listaEquipos[1].puntaje))
                        }
                    })
                }
                partidoAdapter.setPartidos(listaDTO)
            }
        })
        fab.setOnClickListener() {
            val intent = Intent(this, AgregarPartidoActivity::class.java)
            startActivity(intent)
        }
    }

    private fun iniciarActivityPartido(partido: PartidoDTO) {
        val partidoBundle = Bundle()
        partidoBundle.putParcelable("PARTIDO", partido)
        startActivity(Intent(this, DetallePartidoActivity::class.java).putExtra("bundle", partidoBundle))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}

