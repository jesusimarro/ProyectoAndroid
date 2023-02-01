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
import com.example.appfootball.DataClass.Equipos.Listado.Team
import com.example.appfootball.R
import com.example.appfootball.databinding.FragmentEquiposBinding
import com.example.appfootball.Retrofit.FutbolViewModel
import com.example.proyectoapi.DataClass.Competiciones.Listado.Competition

class FragmentEquipos : Fragment() {

    private val ARG_PARAM1 = "competicion"

    private lateinit var binding: FragmentEquiposBinding
    private lateinit var adapter: AdapterEquipos
    private val vm: FutbolViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEquiposBinding.inflate(inflater,container,false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(competicion: Competition) = FragmentEquipos().apply {
            arguments = Bundle().apply {
                putParcelable(ARG_PARAM1, competicion)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configRecycler()

        vm.listado_equipos.observe(viewLifecycleOwner){
            adapter.actualizaLista(it)
        }

        val codigo_competicion = vm.competicion_seleccionada.value
        vm.getListaEquiposCompeticion(codigo_competicion?.code.toString())

    }

    private fun configRecycler() {

        val recyclerView = binding.ListadoEquipos
        adapter = AdapterEquipos(object : AdapterEquipos.EquiposClickListener{
            override fun OnClick(team: Team) {
                vm.equipo_seleccionado.value = team
                findNavController().navigate(R.id.action_fragmentCompeticion_to_fragmentEquipo)
            }
        })
        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }
}
