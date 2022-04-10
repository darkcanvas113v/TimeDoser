package com.sillyapps.timedoser.domain

import com.sillyapps.core.di.AppScope
import com.sillyapps.core_util.ticker.Ticker
import com.sillyapps.timedoser.domain.data.ModelStore
import com.sillyapps.timedoser.domain.model.Day
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class DayInteractor @Inject constructor(
  private val dayRepository: DayRepository,
  private val modelStore: ModelStore,
  private val ticker: Ticker
) {

  private val job = Job()
  private val scope = CoroutineScope(Dispatchers.Main + job)

  private val status = MutableStateFlow<DataState<Day>>(DataState.Loading())

  private val state = status.combine(modelStore.getModel()) { status, day ->
    when (status) {
      is DataState.Success -> DataState.Success(day)
      else -> status
    }
  }

  fun getDay(): Flow<DataState<Day>> {
    scope.launch {
      load()
    }

    return state
  }

  suspend fun load() {
    val day = dayRepository.getDay()
    if (day is DataState.Success) {
      modelStore.changeModel(day.data)
    }
    status.value = day
  }

  fun pause() {
    modelStore.pause()
  }

  fun stop() {
    ticker.stop()
    scope.launch {
      load()
    }
  }

  fun start() {
    scope.launch {
      ticker.getTickerEvents().collect {
        modelStore.progress()
      }
      scope.cancel()
    }
    modelStore.start()
  }

}