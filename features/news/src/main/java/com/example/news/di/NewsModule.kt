package com.example.news.di

import com.example.news.data.api.NewsApiService
import com.example.news.data.repository.NewsRepositoryImpl
import com.example.news.domain.repository.NewsRepository
import com.example.news.domain.usecases.GetNewsUseCase
import com.example.news.presentation.screens.newslist.NewsListViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val newsModule = module {
    single<NewsApiService> {
        Retrofit.Builder()
            .baseUrl("https://ekbsite.ru/api.php/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(NewsApiService::class.java)
    }

    single<NewsRepository> { NewsRepositoryImpl(get()) } // Добавляем get() для NewsApiService

    factory { GetNewsUseCase(get()) } // Добавляем get() для NewsRepository

    viewModel { NewsListViewModel(get()) } // Добавляем get() для GetNewsUseCase
}