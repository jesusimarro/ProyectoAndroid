package com.example.appfootball.Clases

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appfootball.R
import com.example.appfootball.Retrofit.FutbolViewModel
import com.example.appfootball.databinding.FragmentCompeticionesBinding
import com.example.proyectoapi.Adapters.AdapterCompeticion
import com.example.proyectoapi.DataClass.Competiciones.Listado.Competition

class FragmentCompeticiones : Fragment() {

    private lateinit var binding: FragmentCompeticionesBinding
    private lateinit var adapter: AdapterCompeticion
    private val vm: FutbolViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCompeticionesBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configRecycler()

        vm.listado_competiciones.observe(viewLifecycleOwner) {
            adapter.actualizaLista(it)
        }

        vm.getListaCompeticiones()
    }

    private fun configRecycler() {
        val recyclerView = binding.recyclerViewCompeticiones

        adapter = AdapterCompeticion(object : AdapterCompeticion.CompeticionesClickListener{
            override fun OnClick(competicion: Competition, codigo : String) {
                vm.competicion_seleccionada.value = competicion
                competicion.code.toString()
                findNavController().navigate(R.id.action_fragmentCompeticiones_to_fragmentCompeticion)
            }
        })
        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }
}