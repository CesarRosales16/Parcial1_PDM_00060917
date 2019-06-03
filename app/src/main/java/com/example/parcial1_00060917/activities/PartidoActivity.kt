package com.example.parcial1_00060917.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.example.parcial1_00060917.R
import kotlinx.android.synthetic.main.activity_partido.*

class PartidoActivity : AppCompatActivity() {
    var scoreTeam1 = 0
    var scoreTeam2 = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_partido)

        tv_fecha.text = intent.getStringExtra("fecha")
        tv_hora.text = intent.getStringExtra("hora")
        tv_team1.text = intent.getStringExtra("nommbre_team1")
        tv_team2.text = intent.getStringExtra("nommbre_team2")
        val scoreTeam1 = ViewModelProviders.of(this).get(contadorViewModel::class.java)
        val scoreTeam2 = ViewModelProviders.of(this).get(contadorViewModel::class.java)

        val scoreObserver1 = Observer<Int> { newInt ->
            // Update the UI, in this case, a TextView.
            tv_contTeam1.text = newInt.toString()
        }
        val scoreObserver2 = Observer<Int> { newInt ->
            // Update the UI, in this case, a TextView.
            tv_contTeam2.text = newInt.toString()
        }
        scoreTeam1.contador1.observe(this, scoreObserver1)
        scoreTeam2.contador2.observe(this, scoreObserver2)

        btn_Tres_team1.setOnClickListener() {
            scoreTeam1.anotarA(3)
        }
        btn_Dos_team1.setOnClickListener() {
            scoreTeam1.anotarA(2)
        }
        btn_Uno_team1.setOnClickListener() {
            scoreTeam1.anotarA(1)
        }
        btn_Tres_team2.setOnClickListener() {
            scoreTeam2.anotarB(3)
        }
        btn_Dos_team2.setOnClickListener() {
            scoreTeam2.anotarB(2)
        }
        btn_Uno_team2.setOnClickListener() {
            scoreTeam2.anotarB(1)
        }

    }

    class contadorViewModel : ViewModel() {
        var aux1 = 0
        var aux2 = 0

        val contador1 = MutableLiveData<Int>()
        val contador2 = MutableLiveData<Int>()

        fun anotarA(i: Int) {
            aux1 = aux1 + i
            contador1.postValue(aux1)
        }

        fun anotarB(i: Int) {
            aux2 = aux2 + i
            contador2.postValue(aux2)
        }
    }
}
