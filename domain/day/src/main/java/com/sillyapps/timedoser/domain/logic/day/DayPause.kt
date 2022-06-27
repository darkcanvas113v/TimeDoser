package com.sillyapps.timedoser.domain.logic.day

import com.sillyapps.timedoser.domain.model.Day

internal fun Day.pause(): Day {
  return this.copy(
    state = Day.State.WAITING
  )
}