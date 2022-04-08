package com.sillyapps.timedoser.domain.model

data class Day(
  val name: String,
  val templateId: Long,
  val tasks: List<RunningTask>,
  val state: State,
  val currentTaskPos: Int
) {
  enum class State {
    ACTIVE, WAITING, COMPLETED, DISABLED
  }

  companion object {
    val EMPTY = Day(
      name = "",
      templateId = 0L,
      tasks = emptyList(),
      state = State.WAITING,
      currentTaskPos = 0
    )
  }
}