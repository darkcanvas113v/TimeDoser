package com.sillyapps.timedoser.domain.logic.task

import com.sillyapps.timedoser.domain.model.RunningTask

internal fun RunningTask.progress(): RunningTask {
  val newProgress = System.currentTimeMillis() - startTime

  if (newProgress >= duration) {
    return completeTask()
  }

  return copy(progress = newProgress)
}