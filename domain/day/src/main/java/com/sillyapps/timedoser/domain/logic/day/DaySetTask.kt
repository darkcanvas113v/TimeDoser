package com.sillyapps.timedoser.domain.logic.day

import com.sillyapps.timedoser.domain.model.Day
import com.sillyapps.timedoser.domain.model.RunningTask
import com.sillyapps.timedoser.domain.model.mutable.MutableDay
import com.sillyapps.timedoser.domain.model.mutable.MutableTask
import com.sillyapps.timedoser.domain.model.mutable.toMutableTask

internal fun MutableDay.setTask(pos: Int, task: RunningTask) {
  if (pos == -1) {
    val taskToAdd = task.copy(
      startTime = getEndTime(),
      state = RunningTask.State.WAITING,
      progress = 0
    )

    tasks.add(
      taskToAdd.toMutableTask()
    )
  }
  else {
    tasks[pos].apply {
      duration = task.duration
      name = task.name
    }
  }
}