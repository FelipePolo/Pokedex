package com.felipepolo.pokedex.ui.MainFragment.PokemonList

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.felipepolo.pokedex.Application.injection.Scopes.FragmentScope
import com.felipepolo.pokedex.Presentation.MainViewModel
import com.felipepolo.pokedex.R
import com.felipepolo.pokedex.data.model.Pokemon
import com.felipepolo.pokedex.databinding.FragmentListBinding
import com.felipepolo.pokedex.utils.Resource
import com.felipepolo.pokedex.utils.ShowIf
import com.felipepolo.pokedex.utils.ShowSnack
import com.felipepolo.pokedex.utils.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

private const val ARG_GENERATION = "generation"

@FragmentScope
class ListFragment : DaggerFragment(), ListPokemonAdapter.OnPokemonClickInterface {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel by viewModels<MainViewModel> { viewModelFactory }

    private lateinit var generation: String
    private lateinit var binding: FragmentListBinding
    private lateinit var pokemonAdapter: ListPokemonAdapter

    companion object {
        @JvmStatic
        fun newInstance(generation: String) =
            ListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_GENERATION, generation)
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            generation = it.getString(ARG_GENERATION).toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        pokemonAdapter = ListPokemonAdapter(requireContext(),this)
        binding.pokemonRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.pokemonRecycler.adapter = pokemonAdapter
        viewModel.getPokemonList(generation).observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Loading -> {
                    binding.progressBar.ShowIf(true)
                }

                is Resource.Success -> {
                    binding.progressBar.ShowIf(false)
                    pokemonAdapter.setPokemonList(it.data)
                }

                is Resource.Failure -> {
                    binding.progressBar.ShowIf(false)
                    binding.root.ShowSnack("ERROR: ${it.exception}")
                }
            }

        })
    }

    override fun onPokemonClick(pokemon: Pokemon, position: Int) {
        val bundle = Bundle()
        bundle.putString("pokemon",pokemon.name)
        findNavController().navigate(R.id.action_mainFragment_to_detailFragment,bundle)
    }
}