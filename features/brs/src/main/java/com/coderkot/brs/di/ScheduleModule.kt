package com.coderkot.brs.di

import com.coderkot.brs.data.repository.SubjectsRepositoryImpl
import com.coderkot.brs.domain.repository.SubjectsRepository
import com.coderkot.brs.domain.usecases.GetSubjects
import com.coderkot.brs.presentation.viewmodel.SubjectsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val scheduleModule = module {
    single<SubjectsRepository> { SubjectsRepositoryImpl() }
    factory { GetSubjects(get()) }
    viewModel { SubjectsViewModel(get()) }
}