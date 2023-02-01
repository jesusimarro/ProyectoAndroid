package com.example.appfootball.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appfootball.databinding.ItemClasificacionBinding
import com.example.appfootball.databinding.ItemCompeticionBinding
import com.example.proyectoapi.Adapters.AdapterCompeticion
import com.example.proyectoapi.DataClass.Competiciones.Estadisticas.Standing
import com.example.proyectoapi.DataClass.Competiciones.Estadisticas.Table
import com.example.proyectoapi.DataClass.Competiciones.Listado.Competition

class AdapterClasificacion(val listener: AdapterClasificacion.ClasificacionClickListener) :
    RecyclerView.Adapter<AdapterClasificacion.CeldaHolder>() {

        private val listaClasificacion = ArrayList<Table>()

        interface ClasificacionClickListener {
            fun OnClick(clasificacion: Table)
        }

        inner class CeldaHolder(val binding: ItemClasificacionBinding) :
            RecyclerView.ViewHolder(binding.root)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CeldaHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemClasificacionBinding.inflate(inflater, parent, false)
            return CeldaHolder(binding)
        }

        override fun onBindViewHolder(holder: CeldaHolder, position: Int) {
            val itemClasificacion: Table = listaClasificacion.get(position)
            holder.binding.nombreEquipoClasificado.text = itemClasificacion.position.toString().plus(" ").plus(itemClasificacion.team?.name)
            holder.binding.pts.text = itemClasificacion.points.toString()
            holder.binding.PJ.text = itemClasificacion.playedGames.toString()
            holder.binding.V.text = itemClasificacion.won.toString()
            holder.binding.E.text = itemClasificacion.draw.toString()
            holder.binding.D.text = itemClasificacion.lost.toString()
            holder.binding.GF.text = itemClasificacion.goalsFor.toString()
            holder.binding.GC.text = itemClasificacion.goalsAgainst.toString()
            holder.binding.GD.text = itemClasificacion.goalDifference.toString()
            Glide.with(holder.itemView).load(itemClasificacion.team?.crest).into(holder.binding.escudo)
            holder.itemView.setOnClickListener {
                listener.OnClick(itemClasificacion)
            }
        }

        override fun getItemCount(): Int {
            return listaClasificacion.size
        }

        fun actualizaLista(lista: ArrayList<Table>) {
            listaClasificacion.clear()
            listaClasificacion.addAll(lista)
            notifyDataSetChanged()
        }
    }