package com.sillyapps.timedoser.domain.model

data class RunningTask(
  val startTime: Long,
  val duration: Long,
  val name: String,
  val state: State,
  val progress: Long
) {
  enum class State {
    WAITING, ACTIVE, COMPLETED, DISABLED
  }
}
