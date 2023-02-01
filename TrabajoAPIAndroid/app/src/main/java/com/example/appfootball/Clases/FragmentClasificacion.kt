package com.example.appfootball.Clases

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appfootball.Adapters.AdapterClasificacion
import com.example.appfootball.R
import com.example.appfootball.Retrofit.FutbolViewModel
import com.example.appfootball.databinding.FragmentClasificacionBinding
import com.example.appfootball.databinding.FragmentCompeticionesBinding
import com.example.proyectoapi.Adapters.AdapterCompeticion
import com.example.proyectoapi.DataClass.Competiciones.Estadisticas.Table
import com.example.proyectoapi.DataClass.Competiciones.Listado.Competition

class FragmentClasificacion : Fragment() {
    private lateinit var binding: FragmentClasificacionBinding
    private lateinit var adapter: AdapterClasificacion
    private val vm: FutbolViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentClasificacionBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configRecycler()

        vm.listado_clasificacion.observe(viewLifecycleOwner) {
            adapter.actualizaLista(it)
        }

        vm.competicion_seleccionada.observe(viewLifecycleOwner){
            (activity as AppCompatActivity?)!!.supportActionBar!!.title = it.name
        }
        val codigoCompeticion = vm.competicion_seleccionada.value
        vm.getTablaClasificacion(codigoCompeticion?.code.toString())
    }

    private fun configRecycler() {
        val recyclerView = binding.ListaClasificacion

        adapter = AdapterClasificacion(object : AdapterClasificacion.ClasificacionClickListener {
            override fun OnClick(clasificacion: Table) {
//                vm.clasificacion_seleccionada.value = clasificacion
//                findNavController().navigate(R.id.action_fragmentClasificacion_to_fragmentEquipo)
            }
        })
        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }
}