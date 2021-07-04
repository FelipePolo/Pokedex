package com.felipepolo.pokedex.ui.MainFragment.PokemonList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.felipepolo.pokedex.core.BaseViewHolder
import com.felipepolo.pokedex.data.model.Pokemon
import com.felipepolo.pokedex.databinding.TemplatePokemonListBinding

class ListPokemonAdapter(
    private val context: Context,
    private val onPokemonClickInterface: OnPokemonClickInterface
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    private var pokemonList = listOf<Pokemon>()

    interface OnPokemonClickInterface {
        fun onPokemonClick(pokemon: Pokemon, position: Int)
    }

    fun setPokemonList(newPokemonList: List<Pokemon>){
        pokemonList = newPokemonList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val binding = TemplatePokemonListBinding.inflate(LayoutInflater.from(context),parent,false)
        return PokemonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is PokemonViewHolder -> {
                holder.bind(pokemonList[position],position)
            }
        }
    }

    override fun getItemCount(): Int {
      return  pokemonList.size
    }

    inner class PokemonViewHolder(val binding:TemplatePokemonListBinding): BaseViewHolder<Pokemon>(binding.root){
        override fun bind(item: Pokemon, position: Int) {
            Glide.with(context)
                .load(item.sprites.front_default)
                .into(binding.pokemonImagen)
            binding.expBar.progress = item.base_experience.toFloat()
            binding.expBar.labelText = "Base XP ${item.base_experience}%"
            binding.pokemonName.text = item.name
            binding.tvattack.text = item.stats.get(0).base_stat.toString()
            binding.tvhp.text = item.stats.get(0).base_stat.toString()
            binding.tvdefense.text = item.stats.get(2).base_stat.toString()
            binding.tvattack.text = item.stats.get(1).base_stat.toString()
            binding.tvspeed.text = item.stats.get(5).base_stat.toString()
            // Click Listeners
            binding.pokemonitem.setOnClickListener { onPokemonClickInterface.onPokemonClick(item,position) }
        }
    }
}