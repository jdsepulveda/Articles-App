package com.articles.app.di

import com.articles.BuildConfig
import com.articles.remote.api.ArticlesService
import com.articles.source.RemoteDataSource
import com.articles.source.RemoteDataSourceImpl
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val remoteSourceModule = module {

    single {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .build()
            .create(ArticlesService::class.java)
    }

    single<RemoteDataSource> {
        RemoteDataSourceImpl(get())
    }
}