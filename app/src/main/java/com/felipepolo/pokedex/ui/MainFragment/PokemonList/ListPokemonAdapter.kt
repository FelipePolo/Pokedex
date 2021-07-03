package com.felipepolo.pokedex.ui.MainFragment.PokemonList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.felipepolo.pokedex.core.BaseViewHolder
import com.felipepolo.pokedex.data.model.Pokemon
import com.felipepolo.pokedex.databinding.TemplatePokemonListBinding

class ListPokemonAdapter(
    private val context: Context,
    onPokemonClickInterface: OnPokemonClickInterface
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnPokemonClickInterface {
        fun onPokemonClick(pokemon: Pokemon, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val binding = TemplatePokemonListBinding.inflate(LayoutInflater.from(context),parent,false)
        return PokemonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    inner class PokemonViewHolder(val binding:TemplatePokemonListBinding): BaseViewHolder<Pokemon>(binding.root){
        override fun bind(item: Pokemon, position: Int) {
            binding.expBar.progress = item.base_experience.toFloat()
            binding.pokemonName.text = item.name
            binding.tvattack.text = item.stats.get(0).base_stat.toString()
            //seguir bindeando los demas elementos. averiguar que index es el que sirve para cada attack, healt, etc.
        }
    }
}