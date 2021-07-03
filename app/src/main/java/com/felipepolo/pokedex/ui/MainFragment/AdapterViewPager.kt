package com.felipepolo.pokedex.ui.MainFragment

import androidx.fragment.app.Fragment
import com.felipepolo.pokedex.ui.MainFragment.PokemonList.ListFragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class AdapterViewPager(private val fragment: Fragment): FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return ListFragment.newInstance((position+1).toString())
    }
}