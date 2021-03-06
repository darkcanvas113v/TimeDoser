package com.sillyapps.timedoser.data.template.di

import android.content.SharedPreferences
import com.sillyapps.core.di.AppScope
import com.sillyapps.core.di.IOModule
import com.sillyapps.timedoser.data.template.persistence.TemplateDao
import com.sillyapps.timedoser.domain.template.TemplateRepository
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(modules = [RepositoryModule::class, IOModule::class])
interface TemplateDataComponent {

  fun getTemplateRepository(): TemplateRepository

  @Component.Builder
  interface Builder {
    @BindsInstance
    fun templateDao(dao: TemplateDao): Builder

    @BindsInstance
    fun sharedPref(sharedPreferences: SharedPreferences): Builder

    fun build(): TemplateDataComponent
  }

}