package com.example.appfootball.Clases

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.example.appfootball.Adapters.ViewPagerAdapter
import com.example.appfootball.R
import com.example.appfootball.Retrofit.FutbolViewModel
import com.example.appfootball.databinding.FragmentCompeticionBinding
import com.example.proyectoapi.DataClass.Competiciones.Listado.Competition
import com.google.android.material.tabs.TabLayoutMediator

class FragmentCompeticion : Fragment() {

    private lateinit var binding: FragmentCompeticionBinding
    private val vm: FutbolViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCompeticionBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        vm.competicion_seleccionada.observe(viewLifecycleOwner) { competicion ->

            (activity as AppCompatActivity?)!!.supportActionBar!!.title = competicion.name

            if (competicion.emblem != null) {
                Glide.with(this).load(competicion.emblem).into(binding.ivCompeticion)
            }

            setupViewPager(competicion)

        }
        
        binding.btClasificacion.setOnClickListener {
            it.findNavController().navigate(R.id.action_fragmentCompeticion_to_fragmentClasificacion)
        }
    }

    private fun setupViewPager(competicion: Competition) {
        val adapter = ViewPagerAdapter(this, competicion)
        binding.materialupViewpager.adapter = adapter
        val mediator = TabLayoutMediator(
            binding.tabs, binding.materialupViewpager
        ) { tab, position ->
            when (position) {
                0 -> tab.text = "Equipos"
                1 -> tab.text = "Partidos"
                else -> {
                    tab.text = "Stats"
                }
            }
        }
            mediator.attach()
    }

}