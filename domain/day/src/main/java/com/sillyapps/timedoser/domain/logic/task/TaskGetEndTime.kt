package com.sillyapps.timedoser.domain.logic.task

import com.sillyapps.timedoser.domain.model.RunningTask

internal fun RunningTask.getEndTime(): Long {
  return startTime + duration
}