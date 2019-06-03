package com.example.parcial1_00060917.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial1_00060917.R
import com.example.parcial1_00060917.database.dtos.PartidoDTO
import kotlinx.android.synthetic.main.partido_list_item.view.*


class PartidoAdapter internal constructor(context: Context, val clickListener: (PartidoDTO) -> Unit) : RecyclerView.Adapter<PartidoAdapter.ViewHolder>() {
    private var partidos: ArrayList<PartidoDTO> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.partido_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = partidos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(partidos[position], clickListener)

    internal fun setPartidos(partidos: ArrayList<PartidoDTO>) {
        this.partidos = partidos
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(partido: PartidoDTO, clickListener: (PartidoDTO) -> Unit) = with(itemView) {
            tv_list_name_equipo1.text = partido.team1
            tv_list_score_equipo1.text = partido.team1Score
            tv_list_name_equipo2.text = partido.team2
            tv_list_score_equipo2.text = partido.team2Score
            this.setOnClickListener() {
                clickListener(partido)
            }
        }
    }
}