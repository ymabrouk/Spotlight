package com.mindset.spots.application

import android.app.Application

class SpotsApplication  : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: SpotsApplication
    }
}