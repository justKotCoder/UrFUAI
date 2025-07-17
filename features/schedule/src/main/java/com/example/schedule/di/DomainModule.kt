package com.example.schedule.di

import com.example.schedule.domain.usecase.GetScheduleUseCase
import org.koin.dsl.module


val domainModule = module {
    factory { GetScheduleUseCase(get()) }
}