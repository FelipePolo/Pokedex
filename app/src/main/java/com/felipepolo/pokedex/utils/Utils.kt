package com.felipepolo.pokedex.utils

import android.R
import android.content.Context
import android.view.View
import com.google.android.material.snackbar.Snackbar



fun View.ShowIf(condition: Boolean){
    if (condition){
        this.visibility = View.VISIBLE
    }else{
        this.visibility = View.GONE
    }
}

fun View.ShowSnack(msj: String){
    Snackbar.make(this, msj, Snackbar.LENGTH_LONG)
        .setAction("Ok") { }
        .setActionTextColor(resources.getColor(R.color.holo_red_light))
        .show()
}