package com.sillyapps.timedoser.task.di

import com.sillyapps.core.di.AppScope
import com.sillyapps.timedoser.domain.task.TaskRepository
import com.sillyapps.timedoser.task.TaskRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {
  @AppScope
  @Binds
  fun bindTaskRepository(repositoryImpl: TaskRepositoryImpl): TaskRepository
}