package com.mariobr.segundaprova

import android.app.Application
import com.mariobr.segundaprova.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AnimeApplication: Application()  {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AnimeApplication)
            modules(appModules)
        }
    }
}