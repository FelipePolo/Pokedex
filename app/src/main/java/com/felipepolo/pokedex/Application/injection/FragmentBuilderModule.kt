package com.felipepolo.pokedex.Application.injection

import com.felipepolo.pokedex.ui.MainFragment.MainFragment
import com.felipepolo.pokedex.ui.PokemonDetail.DetailFragment
import com.felipepolo.pokedex.ui.MainFragment.di.MainFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Scope

@Scope
@Retention(value = AnnotationRetention.RUNTIME)
annotation class FragmentScope

@Module
abstract class FragmentBuilderModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [MainFragmentModule::class])
    abstract fun bindMainFragment(): MainFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun bindDetailFragment(): DetailFragment
}