package com.sillyapps.timedoser.domain.logic.day

import com.sillyapps.timedoser.domain.logic.task.progress
import com.sillyapps.timedoser.domain.model.Day
import com.sillyapps.timedoser.domain.model.RunningTask
import com.sillyapps.timedoser.domain.model.mutable.MutableDay

internal fun MutableDay.tick(dt: Long) {
  if (tasks.isEmpty()) return

  val currentTask = tasks[currentTaskPos]

  currentTask.progress(dt)

  if (currentTask.state == RunningTask.State.COMPLETED) {
    setNewTask()
    return
  }
}