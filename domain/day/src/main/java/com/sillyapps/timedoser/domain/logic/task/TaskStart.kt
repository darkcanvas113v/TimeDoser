package com.sillyapps.timedoser.domain.logic.task

import com.sillyapps.timedoser.domain.model.RunningTask

internal fun RunningTask.taskStart(startTime: Long): RunningTask {
  return this.copy(
    startTime = startTime,
    state = RunningTask.State.ACTIVE
  )
}