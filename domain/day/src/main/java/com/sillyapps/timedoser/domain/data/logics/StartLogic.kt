package com.sillyapps.timedoser.domain.data.logics

import com.sillyapps.timedoser.domain.model.Day

object StartLogic {

  fun process(data: Day): Day {
    return data.copy(
      state = Day.State.ACTIVE
    )
  }
}