package com.sillyapps.timedoser.domain.logic.day

import com.sillyapps.timedoser.domain.model.Day

internal fun Day.tick(): Day {
  return this.copy()
}