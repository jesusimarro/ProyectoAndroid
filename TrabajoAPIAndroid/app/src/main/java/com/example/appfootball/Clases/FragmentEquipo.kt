package com.example.appfootball.Clases

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.appfootball.Adapters.AdapterEquipos
import com.example.appfootball.Adapters.AdapterPlantilla
import com.example.appfootball.DataClass.Equipos.Listado.Squad
import com.example.appfootball.DataClass.Equipos.Listado.Team
import com.example.appfootball.DataClass.Jugadores.Jugador
import com.example.appfootball.R
import com.example.appfootball.databinding.FragmentEquipoBinding
import com.example.appfootball.Retrofit.FutbolViewModel

class FragmentEquipo : Fragment() {

    private lateinit var binding: FragmentEquipoBinding
    private lateinit var adapter: AdapterPlantilla
    private val vm: FutbolViewModel by activityViewModels()

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            binding = FragmentEquipoBinding.inflate(inflater,container,false)
            return binding.root
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configRecycler()

        vm.equipo_seleccionado.observe(viewLifecycleOwner) { team ->

            (activity as AppCompatActivity?)!!.supportActionBar!!.title = team.name

            if (team.crest != null) {
                Glide.with(this).load(team.crest).into(binding.ivEscudo)
            }
            binding.tvNombre.text = team.name
            binding.tvEstadio.text = team.venue
            binding.tvDireccion.text = team.address
            binding.tvPais.text = team.area?.name
            binding.tvFundacion.text = team.founded.toString()
            binding.tvColores.text = team.clubColors
            Log.e("prueba",team.toString())

            vm.getPlantillaEquipo(team.id.toString().toInt())
        }

        vm.listado_plantilla.observe(viewLifecycleOwner){
            adapter.actualizaLista(it)
        }


    }

    private fun configRecycler() {

        val recyclerView = binding.ListaPlantilla
        adapter = AdapterPlantilla(object : AdapterPlantilla.PlantillaClickListener{
            override fun OnClick(plantilla: Squad , dato: Jugador) {
                vm.jugadorSeleccionado.value = plantilla
                findNavController().navigate(R.id.action_fragmentEquipo_to_fragmentJugador)
            }
        })
        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }
}