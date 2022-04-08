package com.sillyapps.timedoser.data.day.di

import android.content.SharedPreferences
import com.sillyapps.core.di.AppScope
import com.sillyapps.core.di.IOModule
import com.sillyapps.timedoser.domain.DayRepository
import com.sillyapps.timedoser.domain.template.TemplateRepository
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(modules = [RepositoryModule::class, IOModule::class])
interface DayDataComponent {

  fun getDayRepository(): DayRepository

  @Component.Builder
  interface Builder {
    @BindsInstance
    fun sharedPref(sharedPreferences: SharedPreferences): Builder

    @BindsInstance
    fun templateRepository(templateRepository: TemplateRepository): Builder

    fun build(): DayDataComponent
  }

}