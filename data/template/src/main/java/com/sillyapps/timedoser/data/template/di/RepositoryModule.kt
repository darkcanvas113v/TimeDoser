package com.sillyapps.timedoser.data.template.di

import com.sillyapps.core.di.AppScope
import com.sillyapps.timedoser.domain.template.TemplateRepository
import com.sillyapps.timedoser.data.template.TemplateRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {
  @AppScope
  @Binds
  fun bindTaskRepository(repositoryImpl: TemplateRepositoryImpl): TemplateRepository
}