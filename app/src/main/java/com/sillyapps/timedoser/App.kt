package com.sillyapps.timedoser

import android.app.Application
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
      .database(appComponent.getDatabase())
      .sharedPref(appComponent.getSharedPref())
      .build()
  }

}