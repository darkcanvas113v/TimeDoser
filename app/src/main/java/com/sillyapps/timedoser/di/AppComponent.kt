package com.sillyapps.timedoser.di

import android.content.Context
import com.sillyapps.core.di.AppScope
import com.sillyapps.timedoser.data.AppDatabase
import com.sillyapps.timedoser.task.di.TaskDataComponent
import com.sillyapps.timedoser.task.persistence.TaskDatabase
import dagger.BindsInstance
import dagger.Component

@AppScope()
@Component(modules = [DatabaseModule::class])
interface AppComponent {

  fun getDatabase(): AppDatabase

  @Component.Builder
  interface Builder {
    @BindsInstance
    fun context(context: Context): Builder

    fun build(): AppComponent
  }

}