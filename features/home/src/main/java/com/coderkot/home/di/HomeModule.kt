package com.coderkot.home.di

import com.coderkot.home.data.HomeRepositoryImpl
import com.coderkot.home.domain.repository.HomeRepository
import com.coderkot.home.presentation.viewmodel.HomeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    single<HomeRepository> { HomeRepositoryImpl() }
    viewModel { HomeViewModel(get()) }
}