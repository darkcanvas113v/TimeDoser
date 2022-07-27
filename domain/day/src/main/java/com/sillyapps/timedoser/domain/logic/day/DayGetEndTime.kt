package com.sillyapps.timedoser.domain.logic.day

import com.sillyapps.timedoser.domain.logic.task.getEndTime
import com.sillyapps.timedoser.domain.model.mutable.MutableDay

internal fun MutableDay.getEndTime(): Long {
  if (tasks.isEmpty()) return 0L
  return tasks.last().getEndTime()
}