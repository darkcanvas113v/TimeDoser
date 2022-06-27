package com.sillyapps.timedoser.domain.logic.day

import com.sillyapps.timedoser.domain.model.Day
import com.sillyapps.timedoser.domain.model.RunningTask

internal fun Day.setTask(pos: Int, task: RunningTask): Day {
  val mutTasks = tasks.toMutableList()

  if (pos == -1) {
    mutTasks.add(
      task.copy(
        startTime = getEndTime(),
        state = RunningTask.State.WAITING,
        progress = 0
      )
    )
  }
  else {
    val prev = mutTasks[pos]
    mutTasks[pos] = task.copy(
      startTime = prev.startTime,
      state = prev.state,
      progress = prev.progress
    )
  }

  return this.copy(tasks = mutTasks)
}