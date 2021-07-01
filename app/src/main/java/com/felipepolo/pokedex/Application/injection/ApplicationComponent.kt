package com.felipepolo.pokedex.Application.injection

import android.app.Activity
import android.content.Context
import com.felipepolo.pokedex.Application.MainActivity
import dagger.BindsInstance
import dagger.Component
import dagger.Module


@Component(modules =  [ApplicationModule::class])
interface ApplicationComponent {

    @Component.Factory
    interface  Factory {
        fun create(@BindsInstance context: Context):ApplicationComponent
    }

    fun inject(mainActivity: MainActivity)
}

@Module
class ApplicationModule{

}