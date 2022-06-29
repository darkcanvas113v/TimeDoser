package com.sillyapps.timedoser.domain.logic.day

import com.sillyapps.timedoser.domain.logic.task.taskStart
import com.sillyapps.timedoser.domain.model.Day

internal fun Day.start(): Day {
  if (tasks.isEmpty()) return this

  val mutTasks = tasks.toMutableList()

  val currentTime = System.currentTimeMillis()
  val newTask = mutTasks[currentTaskPos].taskStart(currentTime)

  mutTasks[currentTaskPos] = newTask

  return this.copy(
    state = Day.State.ACTIVE,
    tasks = mutTasks
  )
}