package com.sillyapps.timedoser.domain

import com.sillyapps.core_util.ticker.Ticker
import com.sillyapps.timedoser.domain.logic.day.tick
import com.sillyapps.timedoser.domain.model.Day
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class DayProgressWatcher @Inject constructor(
  private val repository: DayRepository,
  appScope: CoroutineScope,
  private val ticker: Ticker
) {

  init {
    appScope.launch {
      ticker.getTicks().collect { dt ->
        progress(dt)
      }
    }
  }

  private suspend fun progress(dt: Long) {
    val day = repository.getDayRaw().tick(dt)

    if (day.state != Day.State.ACTIVE)
      ticker.stop()

    repository.setDay(day)
  }

}