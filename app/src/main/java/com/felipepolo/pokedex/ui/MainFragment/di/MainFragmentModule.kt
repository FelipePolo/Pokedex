package com.felipepolo.pokedex.ui.MainFragment.di

import androidx.lifecycle.ViewModel
import com.felipepolo.pokedex.Presentation.MainViewModel
import com.felipepolo.pokedex.domain.MainRepository
import com.felipepolo.pokedex.domain.MainRepositoryInterface
import com.felipepolo.pokedex.ui.MainFragment.PokemonList.ListFragment
import com.felipepolo.pokemonapp.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class MainFragmentModule {

    @ContributesAndroidInjector
    abstract fun bindListFragment(): ListFragment

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    abstract fun provideRepo(mainRepository: MainRepository): MainRepositoryInterface
}