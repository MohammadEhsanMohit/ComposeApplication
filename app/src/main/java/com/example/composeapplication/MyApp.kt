package com.example.composeapplication

import android.app.Application
import com.example.composeapplication.di.appModule
import com.example.composeapplication.di.dataBase
import com.example.composeapplication.di.repositoryModule
import com.example.composeapplication.di.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(
                listOf(
                    appModule,
                    dataBase,
                    repositoryModule,
                    useCaseModule
                )
            )
        }
    }
}