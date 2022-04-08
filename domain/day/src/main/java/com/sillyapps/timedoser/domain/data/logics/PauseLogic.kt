package com.sillyapps.timedoser.domain.data.logics

import com.sillyapps.timedoser.domain.model.Day

object PauseLogic {

  fun process(data: Day): Day {
    return data.copy(
      state = Day.State.DISABLED
    )
  }

}