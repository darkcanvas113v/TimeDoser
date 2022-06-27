package com.sillyapps.timedoser.domain.logic.task

import com.sillyapps.timedoser.domain.model.RunningTask

internal fun RunningTask.completeTask(): RunningTask {
  return this.copy(
    state = RunningTask.State.COMPLETED,
    duration = progress
  )
}