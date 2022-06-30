package com.sillyapps.timedoser.domain.logic.task

import com.sillyapps.timedoser.domain.model.RunningTask

internal fun RunningTask.pause(): RunningTask {
  return copy(
    state = RunningTask.State.DISABLED
  )
}