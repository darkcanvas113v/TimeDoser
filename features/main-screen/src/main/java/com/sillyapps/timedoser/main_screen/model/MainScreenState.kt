package com.sillyapps.timedoser.main_screen.model

import com.sillyapps.timedoser.domain.model.Day

data class MainScreenState(
  val state: Int,
  val name: String,
  val tasks: List<TaskUIModel>,
  val dayState: Int,
  val currentTaskPos: Int
) {
  companion object {
    const val STATE_LOADING = 0
    const val STATE_SUCCESS = 1

    val INITIAL = MainScreenState(
      state = STATE_LOADING,
      name = "",
      tasks = emptyList(),
      dayState = Day.State.WAITING.ordinal,
      currentTaskPos = 0
    )
  }
}
