package com.sillyapps.timedoser.domain.logic.day

import com.sillyapps.timedoser.domain.model.Day

internal fun Day.start(): Day {
  return this.copy(
    state = Day.State.ACTIVE
  )
}