package com.sillyapps.timedoser.domain.logic.day

import com.sillyapps.timedoser.domain.logic.task.completeTask
import com.sillyapps.timedoser.domain.logic.task.getEndTime
import com.sillyapps.timedoser.domain.logic.task.taskStart
import com.sillyapps.timedoser.domain.model.Day
import com.sillyapps.timedoser.domain.model.RunningTask

internal fun Day.setNewTask(): Day {
  val mutTasks = tasks.toMutableList()

  val currentTask = mutTasks[currentTaskPos]
  if (currentTask.state != RunningTask.State.COMPLETED) {
    mutTasks[currentTaskPos] = currentTask.completeTask()
  }

  var nextTask = currentTaskPos + 1

  for (i in nextTask until tasks.size) {
    if (tasks[i].state == RunningTask.State.DISABLED) {
      mutTasks[i] = mutTasks[i].completeTask()
      nextTask += 1
    } else {
      break
    }
  }

  if (nextTask == tasks.size) {
    return this.copy(
      state = Day.State.COMPLETED,
      tasks = mutTasks,
      currentTaskPos = tasks.lastIndex
    )
  }

  mutTasks[currentTaskPos] = mutTasks[currentTaskPos].completeTask()
  mutTasks[currentTaskPos + 1] =
    mutTasks[currentTaskPos + 1].taskStart(startTime = mutTasks[currentTaskPos].getEndTime())

  return this.copy(
    tasks = mutTasks,
    currentTaskPos = currentTaskPos + 1
  )
}