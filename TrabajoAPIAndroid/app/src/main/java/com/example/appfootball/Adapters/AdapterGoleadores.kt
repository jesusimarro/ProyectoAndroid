package com.example.appfootball.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appfootball.DataClass.Competiciones.Goleadoers.Scorer
import com.example.appfootball.DataClass.Equipos.Partidos.Matche
import com.example.appfootball.R
import com.example.appfootball.databinding.ItemGoleadorBinding
import com.example.appfootball.databinding.ItemPartidosBinding

class AdapterGoleadores(val listener: GoleadoresClickListener) :
    RecyclerView.Adapter<AdapterGoleadores.CeldaHolder>() {

    private var listaGoleadores = ArrayList<Scorer>()

    interface GoleadoresClickListener{
        fun OnClick(goleador: Scorer)
    }

    inner class CeldaHolder(val binding: ItemGoleadorBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CeldaHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemGoleadorBinding.inflate(inflater, parent, false)
        return CeldaHolder(binding)
    }

    override fun onBindViewHolder(holder: AdapterGoleadores.CeldaHolder, position: Int) {
        val itemGoleador: Scorer = listaGoleadores[position]

        holder.binding.tvNombre.text = itemGoleador.player?.name
        holder.binding.tvEquipo.text = itemGoleador.team?.name
        holder.binding.tvGoles.text = itemGoleador.goals.toString()
        holder.binding.ivJugador.setImageResource(R.drawable.placeholderplayer)

        holder.itemView.setOnClickListener {
            listener.OnClick(itemGoleador)
        }
    }
    override fun getItemCount(): Int {
        return listaGoleadores.size
    }

    fun actualizaLista(lista: ArrayList<Scorer>) {
        listaGoleadores.clear()
        listaGoleadores.addAll(lista)
        notifyDataSetChanged()
    }
}