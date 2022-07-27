package com.sillyapps.timedoser.domain.api

import com.sillyapps.core.di.AppScope
import com.sillyapps.timedoser.domain.DayProgressWatcher
import com.sillyapps.timedoser.domain.DayRepository
import com.sillyapps.timedoser.domain.di.DaggerDayComponent
import kotlinx.coroutines.CoroutineScope

class DayDomainModule(
  appScope: CoroutineScope,
  dayRepository: DayRepository
) {

  val dayComponent = DaggerDayComponent.builder()
    .appScope(appScope)
    .repository(dayRepository)
    .build()

  val dayProgressWatcher = dayComponent.getDayProgressWatcher()

}