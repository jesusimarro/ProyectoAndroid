package com.example.appfootball.Clases

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.appfootball.DataClass.Jugadores.Jugador
import com.example.appfootball.databinding.FragmentJugadorBinding
import com.example.appfootball.Retrofit.FutbolViewModel

class FragmentJugador : Fragment() {

    private lateinit var binding: FragmentJugadorBinding
    private val vm: FutbolViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentJugadorBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.jugadorSeleccionado.observe(viewLifecycleOwner){ jugador ->

            (activity as AppCompatActivity?)!!.supportActionBar!!.title = jugador.name
            binding.jugador.text = jugador.name
            binding.PosicionJugador.text = jugador.position
            binding.NacionalidadJugador.text = jugador.nationality
            binding.fechaNacJugador.text = jugador.dateOfBirth
//            binding.Dorsal.text = jugador.shirtNumber.toString()
//            binding.ContratoJugador.text = jugador.contract?.start.toString().plus(" - ").plus(jugador.contract?.until)
            // Log.e("datos",jugador.toString()) Para mostrar que carga datos nulls
        }

        vm.goleadorSeleccionado.observe(viewLifecycleOwner){ jugador ->
            binding.jugador.text = jugador.player?.name
            binding.PosicionJugador.text = jugador.player?.position
            binding.NacionalidadJugador.text = jugador.player?.nationality
            binding.fechaNacJugador.text = jugador.player?.dateOfBirth
            //            binding.Dorsal.text = jugador.player?.shirtNumber.toString()
            // Log.e("datos",jugador.toString()) Para mostrar que carga datos nulls
        }

    }
}