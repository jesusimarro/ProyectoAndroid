package com.example.appfootball.Adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.appfootball.Clases.Tabs.FragmentEquipos
import com.example.appfootball.Clases.Tabs.FragmentGoleadores
import com.example.appfootball.Clases.Tabs.FragmentPartidos
import com.example.proyectoapi.DataClass.Competiciones.Listado.Competition

class ViewPagerAdapter(fragment: Fragment, val competicion: Competition) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return if (position == 0)
            FragmentEquipos.newInstance(competicion)
        else if (position == 1)
            FragmentPartidos()
        else
            FragmentGoleadores()
    }
}