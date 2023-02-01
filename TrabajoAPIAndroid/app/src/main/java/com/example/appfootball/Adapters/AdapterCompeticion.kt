package com.example.proyectoapi.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appfootball.R
import com.example.appfootball.databinding.ItemCompeticionBinding
import com.example.proyectoapi.DataClass.Competiciones.Listado.Competition

class AdapterCompeticion(val listener: CompeticionesClickListener) :
    RecyclerView.Adapter<AdapterCompeticion.CeldaHolder>() {

    private val listaCompeticiones = ArrayList<Competition>()

    interface CompeticionesClickListener{
        fun OnClick(competicion: Competition, codigo: String)
    }

    inner class CeldaHolder(val binding: ItemCompeticionBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CeldaHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCompeticionBinding.inflate(inflater, parent, false)
        return CeldaHolder(binding)
    }

    override fun onBindViewHolder(holder: CeldaHolder, position: Int) {
        val itemcompeticion: Competition = listaCompeticiones.get(position)
        holder.binding.tvNombreCompeticion.text = itemcompeticion.name
        if (itemcompeticion.emblem != null) {
            Glide.with(holder.itemView).load(itemcompeticion.emblem).into(holder.binding.ivLogoComp)
        } else {
            holder.binding.ivLogoComp.setImageResource(R.drawable.placeholderliga)
        }
        holder.itemView.setOnClickListener {
            listener.OnClick(itemcompeticion,itemcompeticion.code.toString())
        }
    }



    override fun getItemCount(): Int {
        return listaCompeticiones.size
    }

    fun actualizaLista(lista: ArrayList<Competition>) {
        listaCompeticiones.clear()
        listaCompeticiones.addAll(lista)
        notifyDataSetChanged()
    }
}