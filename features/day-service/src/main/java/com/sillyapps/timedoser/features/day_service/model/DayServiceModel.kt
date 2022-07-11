package com.sillyapps.timedoser.features.day_service.model

import com.sillyapps.core_time.convertMillisToStringFormatWithSeconds
import com.sillyapps.timedoser.domain.model.Day

data class DayServiceModel(
  val currentTaskName: String,
  val timeRemained: String,
  val state: Int
) {
  companion object {
    val NULL = DayServiceModel(
      currentTaskName = "",
      timeRemained = "",
      state = 0
    )
  }
}

fun Day.toDayServiceModel(): DayServiceModel {
  val currentTask = tasks[currentTaskPos]
  return DayServiceModel(
    currentTaskName = currentTask.name,
    timeRemained = convertMillisToStringFormatWithSeconds(currentTask.duration - currentTask.progress),
    state = state.ordinal
  )
}