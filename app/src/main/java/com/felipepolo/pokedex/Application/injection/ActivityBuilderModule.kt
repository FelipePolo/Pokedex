package com.felipepolo.pokedex.Application.injection

import androidx.lifecycle.ViewModel
import com.felipepolo.pokedex.Application.MainActivity
import com.felipepolo.pokedex.Application.injection.Scopes.ActivityScope
import com.felipepolo.pokedex.Presentation.MainViewModel
import com.felipepolo.pokedex.domain.MainRepository
import com.felipepolo.pokedex.domain.MainRepositoryInterface
import com.felipepolo.pokemonapp.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [FragmentBuilderModule::class])
    abstract fun bindMainActivity():MainActivity

}