package com.sillyapps.timedoser.data.template.di

import android.content.SharedPreferences
import com.sillyapps.core.di.AppScope
import com.sillyapps.timedoser.domain.template.TemplateRepository
import com.sillyapps.timedoser.data.template.persistence.TemplateDatabase
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(modules = [RepositoryModule::class])
interface TemplateDataComponent {

  fun getTaskRepository(): TemplateRepository

  @Component.Builder
  interface Builder {
    @BindsInstance
    fun database(database: TemplateDatabase): Builder

    @BindsInstance
    fun sharedPref(sharedPreferences: SharedPreferences): Builder

    fun build(): TemplateDataComponent
  }

}