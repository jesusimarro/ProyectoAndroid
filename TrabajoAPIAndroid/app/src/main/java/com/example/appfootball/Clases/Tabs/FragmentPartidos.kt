package com.example.appfootball.Clases.Tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appfootball.Adapters.AdapterEquipos
import com.example.appfootball.Adapters.AdapterPartidos
import com.example.appfootball.DataClass.Equipos.Listado.Team
import com.example.appfootball.DataClass.Equipos.Partidos.Matche
import com.example.appfootball.R
import com.example.appfootball.databinding.FragmentPartidosBinding
import com.example.appfootball.Retrofit.FutbolViewModel
import com.example.proyectoapi.DataClass.Competiciones.Listado.Competition

class FragmentPartidos : Fragment() {

    private lateinit var binding: FragmentPartidosBinding
    private lateinit var adapter: AdapterPartidos
    private val vm: FutbolViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPartidosBinding.inflate(inflater,container,false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(competicion: Competition) = FragmentPartidos().apply {
            arguments = Bundle().apply {
                putParcelable(ARG_PARAM2, competicion)
            }
        }

        private const val ARG_PARAM2 = "competicion"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configRecycler()

        vm.listado_partidos.observe(viewLifecycleOwner){
            adapter.actualizaLista(it)
        }

        val codigo_competicion = vm.competicion_seleccionada.value
        vm.getListaPartidosCompeticion(codigo_competicion?.code.toString())

    }

    private fun configRecycler() {

        val recyclerView = binding.ListadoPartidos
        adapter = AdapterPartidos(object : AdapterPartidos.PartidosClickListener{
            override fun OnClick(partido: Matche) {
                //findNavController().navigate(R.id.action_fragmentEquipos_to_fragmentEquipo)
            }
        })
        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }
}