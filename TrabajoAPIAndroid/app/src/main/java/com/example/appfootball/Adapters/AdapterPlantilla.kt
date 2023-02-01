package com.example.appfootball.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.appfootball.DataClass.Equipos.Listado.Squad
import com.example.appfootball.DataClass.Jugadores.Jugador
import com.example.appfootball.Retrofit.FutbolViewModel
import com.example.appfootball.databinding.CeldaJugadorBinding
import kotlin.coroutines.coroutineContext

class AdapterPlantilla (val listener: PlantillaClickListener) :
    RecyclerView.Adapter<AdapterPlantilla.CeldaHolder>() {

    private var listaPlantilla = ArrayList<Squad>()
    private lateinit var datosJugador: Jugador

    interface PlantillaClickListener{
        fun OnClick(plantilla: Squad, dato: Jugador)
    }

    inner class CeldaHolder(val binding: CeldaJugadorBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CeldaHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CeldaJugadorBinding.inflate(inflater, parent, false)
        return CeldaHolder(binding)
    }

    override fun onBindViewHolder(holder: AdapterPlantilla.CeldaHolder, position: Int) {

        val itemPlantilla: Squad = listaPlantilla[position]
        datosJugador = Jugador("","",0,"","","","","",10)

        holder.binding.tvNombre.text = itemPlantilla.name
        holder.binding.tvPosicion.text = itemPlantilla.position

        holder.itemView.setOnClickListener {
            listener.OnClick(itemPlantilla,datosJugador)
        }
    }
    override fun getItemCount(): Int {
        return listaPlantilla.size
    }

    fun actualizaLista(lista: ArrayList<Squad>) {
        listaPlantilla.clear()
        listaPlantilla.addAll(lista)
        notifyDataSetChanged()
    }
}