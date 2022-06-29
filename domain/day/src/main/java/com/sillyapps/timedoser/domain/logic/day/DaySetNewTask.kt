package com.sillyapps.timedoser.domain.logic.day

import com.sillyapps.timedoser.domain.logic.task.completeTask
import com.sillyapps.timedoser.domain.logic.task.getEndTime
import com.sillyapps.timedoser.domain.logic.task.taskStart
import com.sillyapps.timedoser.domain.model.Day

internal fun Day.setNewTask(): Day {
  if (currentTaskPos == tasks.size - 1) {
    return this.copy(state = Day.State.COMPLETED)
  }

  val mutTasks = tasks.toMutableList()
  val currentTask = mutTasks[currentTaskPos]

  mutTasks[currentTaskPos] = currentTask.completeTask()
  mutTasks[currentTaskPos+1] = mutTasks[currentTaskPos+1].taskStart(startTime = currentTask.getEndTime())

  return this.copy(
    tasks = mutTasks,
    currentTaskPos = currentTaskPos + 1
  )
}