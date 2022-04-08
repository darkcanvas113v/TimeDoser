package com.sillyapps.timedoser.domain.data

import com.sillyapps.timedoser.domain.data.logics.PauseLogic
import com.sillyapps.timedoser.domain.data.logics.ProgressLogic
import com.sillyapps.timedoser.domain.data.logics.StartLogic
import com.sillyapps.timedoser.domain.model.Day
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class ModelStore @Inject constructor() {

  private val model = MutableStateFlow(Day.EMPTY)

  private var lastSystemTime: Long = 0L

  fun getModel(): Flow<Day> {
    return model
  }

  fun changeModel(day: Day) {
    model.value = day
  }

  fun pause() {
    model.value = PauseLogic.process(model.value)
  }

  fun progress() {
    model.value = ProgressLogic.process(model.value, System.currentTimeMillis() - lastSystemTime)
    lastSystemTime = System.currentTimeMillis()
  }

  fun start() {
    lastSystemTime = System.currentTimeMillis()
    model.value = StartLogic.process(model.value)
  }

}