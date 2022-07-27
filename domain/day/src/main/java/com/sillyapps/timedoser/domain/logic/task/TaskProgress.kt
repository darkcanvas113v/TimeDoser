package com.sillyapps.timedoser.domain.logic.task

import com.sillyapps.timedoser.domain.model.RunningTask
import com.sillyapps.timedoser.domain.model.mutable.MutableTask

internal fun MutableTask.progress(dt: Long) {
  val newProgress = progress + dt

  if (newProgress >= duration) {
    completeTask()
    return
  }

  progress = newProgress
}