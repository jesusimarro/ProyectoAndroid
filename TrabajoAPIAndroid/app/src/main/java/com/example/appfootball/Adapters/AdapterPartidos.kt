package com.example.appfootball.Adapters

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appfootball.DataClass.Equipos.Partidos.*
import com.example.appfootball.R
import com.example.appfootball.databinding.ItemPartidosBinding

class AdapterPartidos(val listener: PartidosClickListener) :
    RecyclerView.Adapter<AdapterPartidos.CeldaHolder>() {

    private var listaPartidos = ArrayList<Matche>()

    interface PartidosClickListener{
        fun OnClick(partido: Matche)
    }

    inner class CeldaHolder(val binding: ItemPartidosBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int): CeldaHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPartidosBinding.inflate(inflater, parent, false)
        return CeldaHolder(binding)
    }

    @SuppressLint("ResourceType")
    override fun onBindViewHolder(holder: AdapterPartidos.CeldaHolder, position: Int) {
        val itemPartido: Matche = listaPartidos[position]

        holder.binding.tvEquipo1.text = itemPartido.homeTeam?.name
        holder.binding.tvEquipo2.text = itemPartido.awayTeam?.name
        holder.binding.tvGolLocal.text = itemPartido.score?.fullTime?.home.toString()
        holder.binding.tvGolVisitante.text = itemPartido.score?.fullTime?.away.toString()
        Glide.with(holder.itemView).load(itemPartido.homeTeam?.crest).into(holder.binding.ivEquipo1)
        Glide.with(holder.itemView).load(itemPartido.awayTeam?.crest).into(holder.binding.ivEquipo2)
//        if(itemPartido.score?.fullTime?.home.toString().toInt() > itemPartido.score?.fullTime?.away.toString().toInt()){
//            holder.binding.tvGolLocal.setShadowLayer(6f,4F,4F, R.color.sombra)
//            holder.binding.tvGolLocal.setTextColor(R.color.resalto)
//        }

        holder.itemView.setOnClickListener {
            listener.OnClick(itemPartido)
        }
    }
    override fun getItemCount(): Int {
        return listaPartidos.size
    }

    fun actualizaLista(lista: ArrayList<Matche>) {
        listaPartidos.clear()
        listaPartidos.addAll(lista)
        notifyDataSetChanged()
    }
}