package com.sillyapps.timedoser.domain.logic.task

import com.sillyapps.timedoser.domain.model.RunningTask

internal fun RunningTask.progress(dt: Long): RunningTask {
  val newProgress = progress + dt

  if (newProgress >= duration) {
    return completeTask()
  }

  return copy(progress = newProgress)
}