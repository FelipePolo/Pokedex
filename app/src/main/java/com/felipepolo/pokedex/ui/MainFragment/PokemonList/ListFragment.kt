package com.felipepolo.pokedex.ui.MainFragment.PokemonList

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.felipepolo.pokedex.Presentation.MainViewModel
import com.felipepolo.pokedex.databinding.FragmentListBinding
import com.felipepolo.pokedex.utils.Resource
import com.felipepolo.pokedex.utils.ShowIf
import com.felipepolo.pokedex.utils.ShowSnack
import com.felipepolo.pokedex.utils.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

private const val ARG_GENERATION = "generation"

class ListFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    lateinit var viewModel: MainViewModel

    private var generation: String? = null
    lateinit var binding: FragmentListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            generation = it.getString(ARG_GENERATION)
        }
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
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
        binding.pokemonRecycler.layoutManager = LinearLayoutManager(requireContext())

        viewModel.getPokemonList("1").observe(viewLifecycleOwner, Observer {
            when(it){
                is Resource.Loading -> {
                    binding.root.ShowIf(true)
                }

                is Resource.Success -> {
                    binding.root.ShowIf(false)
                    Log.d("debug", "setupRecyclerView: ${it.data}")
                }

                is Resource.Failure -> {
                    binding.root.ShowIf(false)
                    binding.root.ShowSnack("ERROR: ${it.exception}")

                }
            }

        })
    }

    companion object {
        @JvmStatic
        fun newInstance(generation: String) =
            ListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_GENERATION, generation)
                }
            }
    }
}