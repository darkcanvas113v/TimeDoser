package com.sillyapps.timedoser.main_screen.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sillyapps.timedoser.domain.DataState
import com.sillyapps.timedoser.domain.usecases.*
import com.sillyapps.timedoser.main_screen.model.MainScreenState
import com.sillyapps.timedoser.main_screen.model.toUIModel
import kotlinx.coroutines.flow.map
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

  override fun getState() = getDayUseCase().map { state ->
    when (state) {
      is DataState.Success -> {
        state.data.run {
          MainScreenState(
            state = MainScreenState.STATE_SUCCESS,
            name = name,
            tasks = tasks.map { it.toUIModel() },
            dayState = this.state.ordinal,
            currentTaskPos = currentTaskPos
          )
        }
      }
      else -> {
        MainScreenState.INITIAL
      }
    }
  }

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