package com.sillyapps.timedoser

import android.app.Application
import com.sillyapps.timedoser.data.day.di.DaggerDayDataComponent
import com.sillyapps.timedoser.data.template.di.DaggerTemplateDataComponent
import com.sillyapps.timedoser.di.DaggerAppComponent
import com.sillyapps.timedoser.domain.di.DaggerDayComponent
import com.sillyapps.timedoser.features.template_editor_screen.api.SaveTemplateDialogApi
import kotlinx.coroutines.MainScope

class App: Application() {

  private val appScope = MainScope()

  val appComponent by lazy {
    DaggerAppComponent.builder()
      .context(applicationContext)
      .build()
  }

  val templateDataComponent by lazy {
    DaggerTemplateDataComponent.builder()
      .templateDao(appComponent.getDatabase().templateDao)
      .sharedPref(appComponent.getSharedPref())
      .build()
  }

  val dayDataComponent by lazy {
    DaggerDayDataComponent.builder()
      .sharedPref(appComponent.getSharedPref())
      .templateRepository(templateDataComponent.getTemplateRepository())
      .build()
  }

  val dayComponent by lazy {
    DaggerDayComponent.builder()
      .repository(dayDataComponent.getDayRepository())
      .appScope(appScope)
      .build()
  }

}