package com.sillyapps.timedoser.main_screen.ui

import com.sillyapps.timedoser.domain.DataState
import com.sillyapps.timedoser.domain.model.Day
import com.sillyapps.timedoser.domain.model.RunningTask
import kotlinx.coroutines.flow.Flow

interface MainScreenStateHolder {

  fun getDay(): Flow<DataState<Day>>

  fun pause()

  fun stop()

  fun start()

}