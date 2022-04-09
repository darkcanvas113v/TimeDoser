package com.sillyapps.timedoser

/*
* Made by darkcanvas113v
* */

import android.app.Application
import com.sillyapps.timedoser.data.day.di.DaggerDayDataComponent
import com.sillyapps.timedoser.data.template.di.DaggerTemplateDataComponent
import com.sillyapps.timedoser.di.DaggerAppComponent

class App: Application() {

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

}