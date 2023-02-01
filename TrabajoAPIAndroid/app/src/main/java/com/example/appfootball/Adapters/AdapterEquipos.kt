package com.example.appfootball.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appfootball.DataClass.Equipos.Listado.Competition
import com.example.appfootball.DataClass.Equipos.Listado.Team
import com.example.appfootball.databinding.ItemEquipoBinding

class AdapterEquipos(val listener: EquiposClickListener) :
    RecyclerView.Adapter<AdapterEquipos.CeldaHolder>() {

    private var listaEquipos = ArrayList<Team>()

    interface EquiposClickListener {
        fun OnClick(equipo: Team)
    }

    inner class CeldaHolder(val binding: ItemEquipoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CeldaHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemEquipoBinding.inflate(inflater, parent, false)
        return CeldaHolder(binding)
    }

    override fun onBindViewHolder(holder: AdapterEquipos.CeldaHolder, position: Int) {
        val itemEquipo: Team = listaEquipos[position]
        holder.binding.tvNombreEquipo.text = itemEquipo.name
        Glide.with(holder.itemView).load(itemEquipo.crest).into(holder.binding.ivEscudo)
        holder.itemView.setOnClickListener {
            listener.OnClick(itemEquipo)
        }
    }
    override fun getItemCount(): Int {
        return listaEquipos.size
    }

    fun actualizaLista(lista: ArrayList<Team>) {
        listaEquipos.clear()
        listaEquipos.addAll(lista)
        notifyDataSetChanged()
    }
}