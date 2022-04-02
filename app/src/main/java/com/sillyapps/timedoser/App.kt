package com.sillyapps.timedoser

import android.app.Application
import com.sillyapps.timedoser.di.DaggerAppComponent
import com.sillyapps.timedoser.task.di.DaggerTaskDataComponent

class App: Application() {

  val appComponent by lazy {
    DaggerAppComponent.builder().context(applicationContext).build()
  }

  val taskDataComponent by lazy {
    DaggerTaskDataComponent.builder().database(appComponent.getDatabase()).build()
  }

}