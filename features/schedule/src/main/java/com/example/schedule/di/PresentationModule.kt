package com.example.schedule.di

import com.example.schedule.presentation.viewmodel.ScheduleViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { ScheduleViewModel(get()) }
}