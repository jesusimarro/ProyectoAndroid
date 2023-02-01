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
import com.example.appfootball.Adapters.AdapterGoleadores
import com.example.appfootball.DataClass.Competiciones.Goleadoers.Scorer
import com.example.appfootball.DataClass.Equipos.Listado.Team
import com.example.appfootball.R
import com.example.appfootball.databinding.FragmentGoleadoresBinding
import com.example.appfootball.Retrofit.FutbolViewModel
import com.example.proyectoapi.DataClass.Competiciones.Listado.Competition


class FragmentGoleadores : Fragment() {

    private val ARG_PARAM3 = "competicion"
    private lateinit var binding: FragmentGoleadoresBinding
    private lateinit var adapter: AdapterGoleadores
    private val vm: FutbolViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGoleadoresBinding.inflate(inflater,container,false)
        return binding.root
    }
    companion object {
        @JvmStatic
        fun newInstance(competicion: Competition) = FragmentGoleadores().apply {
            arguments = Bundle().apply {
                putParcelable(ARG_PARAM3, competicion)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configRecycler()

        vm.listado_goleadores.observe(viewLifecycleOwner){
            adapter.actualizaLista(it)
        }

        val codigo_competicion = vm.competicion_seleccionada.value
        vm.getListaGoleadoresCompeticion(codigo_competicion?.code.toString())
    }

    private fun configRecycler() {

        val recyclerView = binding.ListadoGoleadores
        adapter = AdapterGoleadores(object : AdapterGoleadores.GoleadoresClickListener{
            override fun OnClick(goleador: Scorer) {
                vm.goleadorSeleccionado.value = goleador
                findNavController().navigate(R.id.action_fragmentCompeticion_to_fragmentJugador)
            }
        })
        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }
}