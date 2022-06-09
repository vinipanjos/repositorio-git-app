package com.example.repositoriosgithub

import android.app.Application
import com.example.repositoriosgithub.data.di.DataModule
import com.example.repositoriosgithub.domain.di.DomainModule
import com.example.repositoriosgithub.presentation.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
        }

        DataModule.load()
        DomainModule.load()
        PresentationModule.load()
    }
}