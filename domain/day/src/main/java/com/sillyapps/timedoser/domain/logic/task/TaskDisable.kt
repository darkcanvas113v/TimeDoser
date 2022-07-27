package com.sillyapps.timedoser.domain.logic.task

import com.sillyapps.timedoser.domain.model.RunningTask

fun RunningTask.disable(): RunningTask {
  return this.copy(
    state = RunningTask.State.DISABLED
  )
}