package com.coderkot.chat.di

import com.coderkot.chat.data.remote.api.ChatService
import com.coderkot.chat.data.repository.ChatRepositoryImpl
import com.coderkot.chat.domain.repository.ChatRepository
import com.coderkot.chat.domain.usecases.GetResponseUseCase
import com.coderkot.chat.presentation.ChatScreenViewModel
import okhttp3.OkHttpClient
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

val chatModule = module {
    single {
        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .build()
        Retrofit.Builder()
            .baseUrl("https://api.deepseek.com/v1/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .build()
    }
    single {
        get<Retrofit>().create(ChatService::class.java)
    }

    single<ChatRepository> { ChatRepositoryImpl(get()) }
    single<GetResponseUseCase> { GetResponseUseCase(get()) }
    viewModel { ChatScreenViewModel(get()) }
}