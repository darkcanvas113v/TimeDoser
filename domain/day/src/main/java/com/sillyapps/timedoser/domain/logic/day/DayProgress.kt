package com.sillyapps.timedoser.domain.logic.day

import com.sillyapps.timedoser.domain.logic.task.progress
import com.sillyapps.timedoser.domain.model.Day
import com.sillyapps.timedoser.domain.model.RunningTask

internal fun Day.tick(): Day {
  if (tasks.isEmpty()) return this

  val mutTasks = tasks.toMutableList()

  val currentTask = mutTasks[currentTaskPos].progress()
  mutTasks[currentTaskPos] = currentTask

  if (currentTask.state == RunningTask.State.COMPLETED)
    return copy(tasks = mutTasks).setNewTask()

  return this.copy(
    tasks = mutTasks
  )
}