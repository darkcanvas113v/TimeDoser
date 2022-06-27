package com.sillyapps.timedoser.main_screen.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sillyapps.timedoser.domain.model.RunningTask
import com.sillyapps.timedoser.domain.usecases.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainScreenViewModel @Inject constructor(
  private val getDayUseCase: GetDayUseCase,
  private val pauseDayUseCase: PauseDayUseCase,
  private val stopDayUseCase: StopDayUseCase,
  private val startDayUseCase: StartDayUseCase,
  private val loadDayUseCase: LoadDayUseCase
): ViewModel(), MainScreenStateHolder {

  init {
    viewModelScope.launch { loadDayUseCase() }
  }

  override fun getDay() = getDayUseCase()

  override fun pause() {
    viewModelScope.launch { pauseDayUseCase() }
  }

  override fun stop() {
    viewModelScope.launch { stopDayUseCase() }
  }

  override fun start() {
    viewModelScope.launch { startDayUseCase() }
  }


}