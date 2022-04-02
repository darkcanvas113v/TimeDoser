package com.sillyapps.timedoser.task.di

import com.sillyapps.core.di.AppScope
import com.sillyapps.timedoser.domain.task.TaskRepository
import com.sillyapps.timedoser.task.TaskRepositoryImpl
import com.sillyapps.timedoser.task.persistence.TaskDatabase
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(modules = [RepositoryModule::class])
interface TaskDataComponent {

  fun getTaskRepository(): TaskRepository

  @Component.Builder
  interface Builder {
    @BindsInstance
    fun database(database: TaskDatabase): Builder

    fun build(): TaskDataComponent
  }

}