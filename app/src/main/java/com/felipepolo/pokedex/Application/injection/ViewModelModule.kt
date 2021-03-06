package com.felipepolo.pokemonapp.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.felipepolo.pokedex.Application.injection.Scopes.FragmentScope
import com.felipepolo.pokedex.Presentation.MainViewModel
import com.felipepolo.pokedex.utils.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
interface ViewModelModule {
    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}