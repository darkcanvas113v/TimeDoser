package com.sillyapps.timedoser.main_screen.ui

import com.sillyapps.timedoser.domain.DataState
import com.sillyapps.timedoser.domain.model.Day
import com.sillyapps.timedoser.domain.model.RunningTask
import com.sillyapps.timedoser.main_screen.model.MainScreenState
import kotlinx.coroutines.flow.Flow

interface MainScreenStateHolder {

  fun getState(): Flow<MainScreenState>

  fun pause()

  fun stop()

  fun start()

}