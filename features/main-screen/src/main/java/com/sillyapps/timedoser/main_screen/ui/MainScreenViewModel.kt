package com.sillyapps.timedoser.main_screen.ui

import androidx.lifecycle.ViewModel
import com.sillyapps.timedoser.domain.DataState
import com.sillyapps.timedoser.domain.DayInteractor
import com.sillyapps.timedoser.domain.model.Day
import com.sillyapps.timedoser.domain.template.usecases.GetAllTemplatesUseCase
import com.sillyapps.timedoser.domain.template.usecases.GetDefaultTemplateUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainScreenViewModel @Inject constructor(
  private val dayInteractor: DayInteractor
): ViewModel(), MainScreenStateHolder {

  override fun getDay() = dayInteractor.getDay()

  override fun pause() {
    dayInteractor.pause()
  }

  override fun stop() {
    dayInteractor.stop()
  }

  override fun start() {
    dayInteractor.start()
  }


}