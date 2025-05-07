package com.coderkot.di

import HomeRepositoryImpl
import HomeViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.test.espresso.core.internal.deps.dagger.Module
import com.coderkot.home.domain.repository.HomeRepository


val homeModule: Module = module {
    single<HomeRepository> { HomeRepositoryImpl() }
    viewModel { HomeViewModel(get()) }
}

val appModules = listOf(homeModule)