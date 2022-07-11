package com.sillyapps.timedoser

import android.app.Application
import android.content.Intent
import com.sillyapps.timedoser.data.day.di.DaggerDayDataComponent
import com.sillyapps.timedoser.data.template.di.DaggerTemplateDataComponent
import com.sillyapps.timedoser.di.DaggerAppComponent
import com.sillyapps.timedoser.domain.DataState
import com.sillyapps.timedoser.domain.api.DayDomainModule
import com.sillyapps.timedoser.domain.di.DaggerDayComponent
import com.sillyapps.timedoser.domain.di.DayComponent
import com.sillyapps.timedoser.domain.model.Day
import com.sillyapps.timedoser.features.day_service.DayService
import com.sillyapps.timedoser.features.day_service.api.DayServiceApp
import com.sillyapps.timedoser.features.day_service.setDayServiceNotificationChannel
import com.sillyapps.timedoser.features.template_editor_screen.api.SaveTemplateDialogApi
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class App: Application(), DayServiceApp {

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

  val dayDomainModule by lazy {
    DayDomainModule(
      appScope = appScope,
      dayRepository = dayDataComponent.getDayRepository()
    )
  }

  override fun onCreate() {
    super.onCreate()

    appScope.launch {
      dayDataComponent.getDayRepository().getDay().collect {
        if (it !is DataState.Success) {
          return@collect
        }

        if (it.data.state == Day.State.ACTIVE) {
          startService(Intent(applicationContext, DayService::class.java))
        }
      }
    }

    setDayServiceNotificationChannel(this)
  }

  override fun getDayComponent(): DayComponent = dayDomainModule.dayComponent

  override fun getMainActivityIntent(): Intent {
    return Intent(this, MainActivity::class.java)
  }

}