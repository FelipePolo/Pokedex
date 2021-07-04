package com.felipepolo.pokedex.Application.injection

import com.felipepolo.pokedex.Application.TodoApplication
import com.felipepolo.pokemonapp.di.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityBuilderModule::class,
        ViewModelModule::class
    ]
)
@Singleton
interface AppGraph : AndroidInjector<TodoApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: TodoApplication): AppGraph
    }
}