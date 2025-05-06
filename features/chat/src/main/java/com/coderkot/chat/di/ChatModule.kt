package com.coderkot.chat.di

import com.coderkot.chat.data.remote.api.ChatService
import com.coderkot.chat.data.repository.ChatRepositoryImpl
import com.coderkot.chat.domain.repository.ChatRepository
import com.coderkot.chat.domain.usecases.GetResponseUseCase
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val chatModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
    single {
        get<Retrofit>().create(ChatService::class.java)
    }

    single<ChatRepository> { ChatRepositoryImpl(get()) }
    single<GetResponseUseCase> { GetResponseUseCase(get()) }
}