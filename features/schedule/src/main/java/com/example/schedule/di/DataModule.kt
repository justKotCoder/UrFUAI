package com.example.schedule.di

import com.example.schedule.data.repository.ScheduleRepositoryImpl
import com.example.schedule.domain.repository.ScheduleRepository
import org.koin.dsl.module

val dataModule = module {
    single<ScheduleRepository> { ScheduleRepositoryImpl() }
}