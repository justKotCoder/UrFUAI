package com.coderkot.chat.di

import com.coderkot.chat.data.remote.api.ChatService
import com.coderkot.chat.data.remote.api.JsonApi
import com.coderkot.chat.data.repository.ChatRepositoryImpl
import com.coderkot.chat.data.repository.JsonRepositoryImpl
import com.coderkot.chat.domain.repository.ChatRepository
import com.coderkot.chat.domain.repository.JsonRepository
import com.coderkot.chat.domain.usecases.GetResponseUseCase
import com.coderkot.chat.domain.usecases.FindAnswerInJsonUseCase
import com.coderkot.chat.presentation.ChatScreenViewModel
import okhttp3.OkHttpClient
import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

val chatModule = module {

    // Retrofit для DeepSeek
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

    // Retrofit для JSON API
    single<JsonApi> {
        get<Retrofit>().newBuilder()
            .baseUrl("https://ekbsite.ru/")
            .build()
            .create(JsonApi::class.java)
    }

    single { get<Retrofit>().create(ChatService::class.java) }
    single<ChatRepository> { ChatRepositoryImpl(get()) }
    single<JsonRepository> { JsonRepositoryImpl(get()) }

    single { GetResponseUseCase(get()) }
    single { FindAnswerInJsonUseCase(get()) }

    viewModel { ChatScreenViewModel(get(), get()) }
}
