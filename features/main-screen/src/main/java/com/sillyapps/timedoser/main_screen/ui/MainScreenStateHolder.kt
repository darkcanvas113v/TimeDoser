package com.sillyapps.timedoser.main_screen.ui

import com.sillyapps.timedoser.domain.DataState
import com.sillyapps.timedoser.domain.model.Day
import kotlinx.coroutines.flow.Flow

interface MainScreenStateHolder {

  val day: Flow<DataState<Day>>

  fun pause()

  fun stop()

  fun start()

}