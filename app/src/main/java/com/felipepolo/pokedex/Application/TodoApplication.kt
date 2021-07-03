package com.felipepolo.pokedex.Application

import android.app.Application
import com.felipepolo.pokedex.Application.injection.DaggerAppGraph
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class TodoApplication: DaggerApplication(){
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppGraph.factory().create(this)
    }
}