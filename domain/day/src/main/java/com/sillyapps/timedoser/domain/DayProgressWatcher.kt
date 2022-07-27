package com.sillyapps.timedoser.domain

import com.sillyapps.core.di.AppScope
import com.sillyapps.core_util.ticker.Ticker
import com.sillyapps.timedoser.domain.logic.day.tick
import com.sillyapps.timedoser.domain.model.Day
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@AppScope
class DayProgressWatcher @Inject constructor(
  appScope: CoroutineScope,
  private val ticker: Ticker,
  private val dayDataSource: DayDataSource
) {

  init {
    appScope.launch {
      ticker.getTicks().collect { dt ->
        progress(dt)
      }
    }
  }

  private fun progress(dt: Long) {
    dayDataSource.modify { day ->
      day.tick(dt)

      if (day.state != Day.State.ACTIVE)
        ticker.stop()
    }
  }

}