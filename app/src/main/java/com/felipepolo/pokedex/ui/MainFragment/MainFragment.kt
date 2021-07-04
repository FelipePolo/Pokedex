package com.felipepolo.pokedex.ui.MainFragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.airbnb.lottie.LottieAnimationView
import com.bumptech.glide.Glide
import com.felipepolo.pokedex.Presentation.MainViewModel
import com.felipepolo.pokedex.databinding.FragmentMainBinding
import com.felipepolo.pokedex.utils.Resource
import com.felipepolo.pokedex.utils.ShowSnack
import com.felipepolo.pokedex.utils.ViewModelFactory
import com.felipepolo.pokedex.utils.setImageFromUrl
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator
import dagger.android.support.DaggerFragment
import javax.inject.Inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel by viewModels<MainViewModel> { viewModelFactory }

    private lateinit var binding: FragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupTabLayout()
        setupTinderView()
    }

    private fun setupTinderView() {
        viewModel.pokemon.observe(viewLifecycleOwner, Observer {
            when(it){
                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    binding.ivPokemon.setImageFromUrl(it.data.sprites.other.official_artwork.front_default)
                }
                is Resource.Failure -> {
                    binding.root.ShowSnack("Error: ${it.exception.message}")
                }
            }
        })
        binding.lLike.setOnClickListener {
            binding.lLike.playAnimation()
            viewModel.getRandomPokemon()
            viewModel.saveFavoritePokemon()
        }
        binding.lDislike.setOnClickListener {
            binding.lDislike.playAnimation()
            viewModel.getRandomPokemon()
        }
    }

    private fun setupTabLayout() {
        binding.viewpager.adapter = AdapterViewPager(this)
        TabLayoutMediator(binding.tablayout,binding.viewpager)
        { tab, position -> tab.text = "gen ${position + 1 }" }.attach()
    }
}