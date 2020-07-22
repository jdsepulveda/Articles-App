package com.articles.app.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

open class ArticleApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ArticleApplication)
            modules(listOf(presentationModule, remoteSourceModule))
        }
    }
}