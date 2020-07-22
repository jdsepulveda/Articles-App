package com.articles.app.di

import com.articles.app.viewmodels.FragmentNewReleasesVM
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { FragmentNewReleasesVM(get()) }
}