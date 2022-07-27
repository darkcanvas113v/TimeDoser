package com.sillyapps.timedoser.domain.logic.day

import com.sillyapps.timedoser.domain.logic.task.completeTask
import com.sillyapps.timedoser.domain.logic.task.getEndTime
import com.sillyapps.timedoser.domain.logic.task.taskStart
import com.sillyapps.timedoser.domain.model.Day
import com.sillyapps.timedoser.domain.model.RunningTask
import com.sillyapps.timedoser.domain.model.mutable.MutableDay

internal fun MutableDay.setNewTask() {
  val currentTask = tasks[currentTaskPos]
  if (currentTask.state != RunningTask.State.COMPLETED) {
    currentTask.completeTask()
  }

  var nextTask = currentTaskPos + 1

  for (i in nextTask until tasks.size) {
    if (tasks[i].state == RunningTask.State.DISABLED) {
      tasks[i].completeTask()
      nextTask += 1
    } else {
      break
    }
  }

  if (nextTask == tasks.size) {
    state = Day.State.COMPLETED
    currentTaskPos = tasks.lastIndex
    return
  }

  tasks[nextTask].taskStart(startTime = tasks[nextTask - 1].getEndTime())
  currentTaskPos = nextTask
}